package Programmers;

//12:30 ~ 1:00 ����
//stones�迭�� ������ ��[2��, 1��, 1��, 2��, 2��]
//1���° ����� �ǳʷ����Ҷ� 1�������� ���ڰ��� �������.
import java.util.*;

class Solution6406202 {
  
  int answer = 0;
  //Integer[] st;
  
  public int solution(int[] stones, int k) {
      
      /*st = new Integer[stones.length];
      for(int i=0; i<st.length; i++){
          st[i] = stones[i];
      }
      
      Arrays.sort(st, Collections.reverseOrder());
      System.out.println(Arrays.toString(st));*/
      int L = 1, R = 200000000;
      //R�� 2������ ������ ������?
      //2��1�� ������ �ʿ䰡 ���� ������, stones�迭�� ��簪�� 2������ �����Ǿ��ְ�, k�� 3�̶�� �Ͽ�����, 2��1��° ����� ������ �ǳ��� ����. 2���° ��������� Ȯ���ϸ� �ɵ�.
      //System.out.println(R);
      while(L <= R){
          int mid = (L + R) / 2;
          if(determination(mid, stones, k)){
              L = mid + 1;
              //answer++�� �ȵǴ� ������? - �־��� �Է����� �����ϰ�, R = 5�� �����غ���,
              //mid = 3�̾����� answer�� �ѹ����ְ�, mid = 4�� �Ǿ�����, �ᱹ �ǳ��� ���ؼ�
              //answer�� 1�� ��ȯ�ϰ� ��.
              answer = Math.max(mid, answer);
          } else {
              R = mid - 1;
          }
      }
      
      return answer;
  }
  
  boolean determination(int x, int[] stones, int k){
      int count = 0;
      for(int i=0; i<stones.length; i++){
          if(x > stones[i]){
              count++;
              if(count >= k){
                  return false;
              }
          } else {
              count = 0;
          }
      }
      return true;
  }
}
