package ex04_Lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
  
  /**
   * 로또 구매<br>
   * 로또 구매를 위해서 사용자로부터 money를 입력 받는 메소드<br>
   * 로또 구매 비용은 최소 1000, 최대 100000이다.<br>
   * @return money 사용자가 입력한 로또 구매 비용에서 1000 미만 단위는 버리고 반환. ex) 5999 입력 시 5000 반환
   * @return 0 로또 구매 실패 시 반환
   */
  public int buyLotto() throws RuntimeException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Lotto를 얼마나 구입하시겠습니까?(최대 10만원) >>> ");
    int money = sc.nextInt();
    if(money < 1000 || money > 100000) {
      money = 0;
      throw new RuntimeException(money + "원 Lotto 구매는 불가능합니다.");
    } else {
      money = money / 1000 * 1000;
    }
    return money;
  }
  
  /**
   * 로또 번호 생성<br>
   * 로또 구매 비용만큼 로또 번호를 생성하는 메소드<br>
   * 5게임씩 끊어서 생성된 로또 번호를 출력한다.<br>
   * @param money 로또 구매 비용
   */
  public void generateLotto(int money) {
    
    

    int cnt = money/1000;
    int N = 6;
    int[] lotto = new int[N];
    int[] temp = new int[N];
    
    Random random = new Random();
    
    for(int n = 0; n < cnt; n++) {
      System.out.print(String.format("%02d", n%5+1) + " : ");
      
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
      if((n+1)%5 == 0) {
        System.out.println("----------------------------------");
      }
    }
  }
}
