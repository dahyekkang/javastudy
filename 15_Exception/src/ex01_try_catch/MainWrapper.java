package ex01_try_catch;

import java.net.URL;
import java.util.Scanner;

public class MainWrapper {

  public static void ex01() {
    
    try {
      String name = "tom";
      Integer.parseInt(name);       // 발생한 NumberFormatException을 catch 블록으로 Java가 던진다.
      } catch(NumberFormatException e) {    // RuntimeException, Exception 가능
        
      // catch(NumberFormatException e)로 하면 예외처리 되지만 catch(NullPointerException e)로 하면 예외 처리 못 함 
      // -> 정확하게 모르면 catch(Exception e) 사용
      // RuntimeException e 해도 예외 처리 된다. -> Unchecked Exception이라는 말 (try - catch가 없어도 되는 예외)
        // parseInt는 언제나 numberformat exception이 발생할 수 있다. try-catch가 없어도 동작하는 코드이므로 동작은 한다.
      System.out.println("예외 발생");
    }
    
  }
  
  
  public static void ex01_1() {
    String name = "tom";
    Integer.parseInt(name);       // java.lang.NumberFormatException
  }
  
  public static void ex02() {
    
    // 다중 catch 블록
    
    try {
      Scanner sc = new Scanner(System.in);
      System.out.println("덧셈식을 입력하세요(예 : 1+2)");
      String expr = sc.next();
      String[] numbers = expr.split("[+]");   // numbers = {"1", "2"}
      int number1 = Integer.parseInt(numbers[0]);   // parseInt : 예외를 던지는 메소드
      int number2 = Integer.parseInt(numbers[1]);   // public static int parseInt(String s) throws NumberFormatException
      System.out.println(number1 + number2);
      sc.close();
    } catch(NumberFormatException e) {
      System.out.println("정수 연산만 가능합니다.");
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("덧셈식에 +를 포함해서 입력하세요.");
    } catch(Exception e) {    // NumberFormatException 과 ArrayIndexOutOfBoundsException 으로 처리 못하는 예외를 담당한다.
      System.out.println("알 수 없는 예외가 발생했습니다.");
    }
    
  }
  
  public static void ex03() {
    
    // 반드시 try - catch가 필요한 예외를 Checked Exception이라고 한다. ★
    
    try {
      URL url = new URL("https://www.naver.com");      
    } catch(Exception e) {
      System.out.println("예외 발생");
    }
    
    
  }
  
  
  public static void main(String[] args) {
    
    ex03();
    
  }

}
