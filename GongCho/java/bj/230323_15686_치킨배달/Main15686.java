package baekjun.DFSBFS;

import java.io.*;
import java.util.*;
//���̷��� ���� �ٽ� Ǯ���
//������ �ڵ�� ���ϸ�, �� �� ġŲ���� selected�� �־��־��µ�,
//���� �ڵ�� selected�迭 ����, �� ġŲ���� isUsed�� true�� ���ִ�,
//isUsed�� true�� ���� ���� ������ָ� ��.

public class Main15686 {
	
	static int n,m, min = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int[][] map;
	static ArrayList<Node> chicken = new ArrayList<Node>();
	static ArrayList<Node> house = new ArrayList<Node>();
	static Node[] selected;
	static boolean[] isUsed;
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "x = " + x + ", y = " + y;
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
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if(a == 2) {
					chicken.add(new Node(i,j));
				}
				if(a == 1) {
					house.add(new Node(i,j));
				}
			}
		}
		
		isUsed = new boolean[chicken.size()];
		selected = new Node[m];
		
		pro(0,0);
		System.out.println(min);

	}
	
	//ġŲ ���� ���� �޼���
	static void pro(int idx, int cnt) {
		if(cnt == m) {
			int sum = 0;
			for(int i=0; i<house.size(); i++) {
				int dist = Integer.MAX_VALUE;
				for(int j=0; j<selected.length; j++) {
					if(selected[j] != null) {
						int distance = Math.abs(house.get(i).x - selected[j].x) + Math.abs(house.get(i).y - selected[j].y);
						dist = Math.min(distance, dist);
					}
				}
				sum += dist;
			}
			//sum += dist;
			min = Math.min(sum, min);
			//System.out.println("min = " + min);
			return;
		}
		
		
		for(int i=idx; i<chicken.size(); i++) {
			if(!isUsed[i]) {
				selected[idx] = new Node(chicken.get(i).x, chicken.get(i).y);
				isUsed[i] = true;
				pro(i + 1, cnt + 1);
				isUsed[i] = false;
			}
		}
	}

}
