package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main169704 {
	
	static int n,k;
	static StringTokenizer st;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n == k) {
			System.out.println(0);
		} else {
			bfs(n);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = 1;
		//ť���ٰ��� ��ǥ�� �ְ�, visited���� +1�� �ð����� ���ٱ�
		q.offer(start);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int nx;
			
			for(int i=0; i<3; i++) {
				
				if(i == 0) {
					nx = x - 1;
				} else if(i == 1) {
					nx = x + 1;
				} else {
					nx = x * 2;
				}
				
				if(nx == k) {
					System.out.println(visited[x]);
					return;
				}
				
				if(nx < 0 || nx > 100000 || visited[nx] != 0) {
					continue;
				}
				
				//������ �߿���. ������� ���� Ȯ���ϱ� ������ nx�� 100001�̶�� visited[100001]�� ���� check�ϹǷ�, indexOutOfError�� ��.
				/*if(visited[nx] != 0 || nx < 0 || nx > 100000) {
					continue;
				}*/
				
				/*if(visited[nx] != 0) {
					continue;
				}*/
				
				/*if(visited[nx] == 0 && (nx >= 0 && nx <= 100000)) {
					visited[nx] = visited[x] + 1;
					q.offer(nx);
				}*/
				if((nx >= 0 && nx <= 100000) && visited[nx] == 0) {
					visited[nx] = visited[x] + 1;
					q.offer(nx);
				}
			}
		}
	}

}
