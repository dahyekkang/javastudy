package ex09_interface;

/*
 * 클래스 상속 vs 인터페이스 구현 구분하기
 * 
 * 1. 클래스를 상속받는다. 라고 표현한다.
 *    public class Person { }
 *    public class Student extends Person { }
 * 2. 인터페이스를 구현한다. 라고 표현한다.
 *    public interface Shape { }
 *    public class Rectangle implements Shape { }
 *    
 *    Shape을 슈퍼타입으로 두고 Rectangle을 서브타입으로 둔다. 표현(키워드)만 다를 뿐 개념은 같은 것이다.
 *    ^ 클래스는 아니기 때문에 슈퍼 타입이라고 표현하지만 정확하게는 인터페이스 이다??
 */


public class Rectangle implements Shape {
  
  private int width;
  private int height;
  
  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }
  
  // 인터페이스를 구현한 클래스는 "반드시" 추상 메소드를 오버라이드 해야 한다 !!!!!!!!!
  @Override
  public double getArea() {
    return width * height;
  }


}
