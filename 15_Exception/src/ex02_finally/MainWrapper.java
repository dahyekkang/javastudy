package ex02_finally;

import java.util.Scanner;

public class MainWrapper {

  // finally 블록
  // 1. try - catch문의 마지막 블록으로 추가할 수 있다. (생략 가능)
  // 2. 예외 발생 여부와 상관 없이 "항상 마지막"에 무조건 실행된다.
  
  public static void main(String[] args) {
    
    // 나이를 입력 받아서 "주류 구매 가능", "주류 구매 불가능" 출력하기
    // 예외 처리
    
    // try 블록과 finally 블록에서 모두 사용할 수 있도록 scope 조정을 해주어야 함
    Scanner sc = null;   // 선언 & 초깃값 설정
    
    try {
      sc = new Scanner(System.in);    // 객체 생성
      System.out.print("나이를 입력하세요 >>> ");
      int age = sc.nextInt();
      System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
    } catch(Exception e) {
      System.out.println("나이를 제대로 입력하세요'^'");
    } finally {
      sc.close();       // finally는 주로 자원 반납용으로 사용한다. (자원 반납할 때 사용하는 코드가 .close()이다.
    }
    
    // {scope} 중괄호 내에서만 변수가 사용될 수 있다. life cycle?!
    // sc가 선언된 try 블록의 중괄호를 벗어나면 sc를 사용할 수 없다.
  }

}
