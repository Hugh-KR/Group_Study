package Programmers;

public class Solution14010802 {

	public int solution(String s) {
		char prev = '1';
		int same = 0, different = 0, answer = 0;
		
		
		//������ �迭�� ���Ҹ� Ȯ���ϰ� ������, Arrays.toString(�������迭�̸�);
		//�̷��� ����ϸ�, for�� ���̵� ���� Ȯ�ΰ���!
		for(char c : s.toCharArray()) {
			if(prev == '1') {
				prev = c;
				answer++;
				same++;
			} else if(prev == c) {
				same++;
			} else {
				different++;
			}
			
			if(same == different) {
				prev = '1';
				same = 0;
				different = 0;
			}
		}
		
		return answer;
	}

}
