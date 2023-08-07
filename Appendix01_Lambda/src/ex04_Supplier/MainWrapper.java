package ex04_Supplier;

import java.util.function.Supplier;

public class MainWrapper {

  /*
   * Supplier 인터페이스
   * 1. 파라미터가 없고 반환 값이 있는 get() 메소드를 가진 함수형 인터페이스이다.
   * 2. 항상 값을 제공하기 때문에 "제공자(Supplier)'라고 부른다.
   * 3. 형식
   *    @FunctionalInterface
   *    public interface Supplier<T> {
   *      T get();
   *    }
   */
  
  public static void ex01() {
    
    // Supplier 객체의 람다 표현식 생성
    Supplier<String> supplier = () -> "Hello World";
    
    System.out.println(supplier.get());
    
  }
  
  public static void main(String[] args) {
    ex01();
  }
  
}
