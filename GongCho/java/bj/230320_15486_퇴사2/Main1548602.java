package baekjun.DynamicProgramming;

import java.io.*;
import java.util.*;

//T�� P�� n+1�� �����Ǵ°� �ƴ�, n+2�� �迭�� �����Ǵ��� ���� �ľ��Ұ�.

public class Main1548602 {
	
	static int n, max = Integer.MIN_VALUE;
	static StringTokenizer st;
	static int[] T,P, dp;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		T = new int[n+2];
		P = new int[n+2];
		dp = new int[n+2];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n+1; i++) {
			//System.out.println("����");
			//max = ���ݱ��� ���� �ݾ�
			max = Math.max(max, dp[i]);
			
			if(i + T[i] <= n+1) {
				dp[i + T[i]] = Math.max(P[i] + max, dp[i + T[i]]);
			}
		}
		
		/*for(int i=1; i<=n+1; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();*/
		
		System.out.println(max);
	}

}
