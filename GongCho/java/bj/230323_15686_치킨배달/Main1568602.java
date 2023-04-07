package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

//8:57 ~ 9:43 - ���� �������� ������ ���

//r�� c�� 1���� �����Ѵ�.
//ġŲ �Ÿ��� ���� ���� ����� ġŲ�� ������ �Ÿ��̴�. ��, ġŲ �Ÿ��� ���� �������� ��������
//������ ġŲ �Ÿ��� ��� ���� ġŲ �Ÿ��� ��
//0�� �� ĭ, 1�� ��, 2�� ġŲ��
//���ÿ� �ִ� ġŲ�� �߿��� �ִ� M���� ����, ������ ġŲ���� ��� ������Ѿ� �Ѵ�.
//������ ġŲ �Ÿ��� ���� �۰� ���� ���ϴ� ���α׷�
public class Main1568602 {
	
	static int n,m, res = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int[][] map;
	static int[] selected_chick;
	static ArrayList<Node> chicken = new ArrayList<Node>();
	static ArrayList<Node> houses = new ArrayList<Node>();
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chicken.add(new Node(i,j));
				} else if(map[i][j] == 1){
					houses.add(new Node(i,j));
				}
			}
		}
		//selected_chick�� m��ŭ ���������߳�? -> ��ġŲ�� �迭�� chicken.size��ŭ ������µ�, �̷��� �ϴ�, �ð����⵵�� 
		//�����ɸ���(���� 4�� ���� �� �� ����)
		//m�� 3�̶�� �����Ͽ�����, [0,4,?] , 0,4���� ���� ���� pro�� Ż�� ��Ž�� ���ᰡ ���� ����. -> .. �� Ȯ���ϴ� �غ���. �ϴ� ����غ���.
		//52���� �� Ȯ���ϱ�(����2�� Ȯ��)
		//����2�� Ȯ���غ���, cand�� ������ 0��~4����.
		//0,4�� ������, pro(idx+1, cnt+1)�� Ÿ�� �Ǹ�, cand�� ������ 5�� ������ �����Ƿ�,
		//���ʿ� for���� ���� ����.
		selected_chick = new int[m];
		pro(0,0);
		System.out.println(res);
	}
	
	static void pro(int idx, int cnt) {
		
		if(cnt == m) {
			//������ġŲ�Ÿ��� ���ϸ� �ɵ�.
			/*for(int i=0; i<selected_chick.length; i++) {
				System.out.print(selected_chick[i] + " ");
			}
			System.out.println();
			System.out.println("=================");*/
			int distance_sum = 0;
			for(int i=0; i<houses.size(); i++) {
				int xh = houses.get(i).x;
				int yh = houses.get(i).y;
				int distance = Integer.MAX_VALUE;
				for(int j=0; j<selected_chick.length; j++) {
					int xc = chicken.get(selected_chick[j]).x;
					int yc = chicken.get(selected_chick[j]).y;
					int d = Math.abs(xh- xc) + Math.abs(yh - yc);
					distance = Math.min(d, distance);
				}
				distance_sum += distance;
			}
			res = Math.min(distance_sum, res);
			//System.out.println(res);
			return;
		}
		
		int start = 0;
		if(idx != 0) {
			start = selected_chick[idx - 1] + 1;
		}
		
		for(int cand = start; cand < chicken.size(); cand++) {
			selected_chick[idx] = cand;
			pro(idx + 1, cnt + 1);
		}
	}

}
