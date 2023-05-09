package baekjun.BackTrack;

import java.io.*;
import java.util.*;

public class Main963303 {
	
	static int n, cnt;
	//nq�� ArrayList�� ���� ���� ���� ������ ����.
	//nq�� index�� ���� ���� ���� ������ ��� �ִ�.
	static ArrayList<Integer> nq = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pro(0);
		System.out.println(cnt);
	}
	
	static void pro(int row) {
		if(row == n) {
			cnt++;
			return;
		}
		
		
		for(int col=0; col<n; col++) {
			if(pruning(col)) {
				nq.add(col);
				pro(row + 1);
				nq.remove(nq.size()-1);
			}
		}
	}
	
	static boolean pruning(int nextcol) {
		int nextRow = nq.size();
		
		for(int row=0; row<nextRow; row++) {
			if((nextcol == nq.get(row)) || (nextRow - row == Math.abs(nq.get(row) - nextcol))) {
				return false;
			}
		}
		return true;
	}

}
