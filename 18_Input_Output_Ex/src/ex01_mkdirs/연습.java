package ex01_mkdirs;

import java.util.Arrays;
import java.util.Random;

public class 연습 {

  public static void main(String[] args) {
    
    int money = 10000;
    int cnt = money/1000;
    int N = 6;
    int[] lotto = new int[N];
    int[] temp = new int[N];
    
    Random random = new Random();
    
    
    for(int n = 0; n < cnt; n++) {
      System.out.print(String.format("%02d", n+1) + " : ");
      
      for(int i = 0; i < N; i++) {
        temp[i] = random.nextInt(45) + 1;
        if(i == 0) {
          lotto[i] = temp[i];
        }
        for(int j = 0; j < i; j++) {
          if(temp[j] == temp[i]) {
            i--;
            break;
          } else {
            lotto[i] = temp[i];          
          }
        }
      }
      
      for(int i = 0; i < N; i++) {
        System.out.print(String.format("%4d", lotto[i]));
      }
      System.out.println();
      
    }
    
  }
  
}
