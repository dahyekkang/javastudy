package ex04_catch;

public class MainWrapper {
  
  public static void ex01() {
    
    try {
      
      // 1. Java가 발생시킨 예외 - 자바가 메시지를 만들어줌
      //int a = 5 / 0;
      //System.out.println(a);
      
      // 2. 개발자가 발생시킨 예외 - 개발자가 직접 예외 사유를 만든다.
      throw new RuntimeException("개발자 예외");
      
    } catch (Exception e) {
      
      // 예외 객체 e가 가진 메소드
      // 예외 클래스 확인하기 - 산술연산예외(ArithmeticException)
      System.out.println(e.getClass().getName());     // Object의 메소드 활용
      
      // 예외 메시지 확인하기(예외가 발생한 이유) - 0으로 나눴다.
      System.out.println(e.getMessage());
      
    }
    
  }
  
  public static void ex02(String name) {
    
    try {
      System.out.println(name.substring(0,1));
    } catch(Exception e) {
      e.printStackTrace();    // 예외 추적 메시지를 출력하는 메소드 (개발 중에는 이것만 사용한다.)
    }
// try catch없을 때의 예외 메시지를 보는 것인데, 이걸 왜하냐면.... try, catch가 없으면 동작되지 않는 코드(Checked Exception)도 있기 때문이다.
    
  }

  public static void main(String[] args) {
    ex02(null);
  }

}
