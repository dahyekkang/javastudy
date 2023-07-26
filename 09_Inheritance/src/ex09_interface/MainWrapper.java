package ex09_interface;

public class MainWrapper {

  public static void main(String[] args) {
    
//    Rectangle r = new Rectangle(3, 4); // 를 사용할 수 있지만 아래 것 사용
    Shape s1 = new Rectangle(3, 4); // 똑같이 부모 타입으로 자식을 저장할 수 있다.
    System.out.println(s1.getArea());
    s1.info1();
    Shape.info2();
    
    Shape s2 = new Circle(1.5);
    System.out.println(s2.getArea());
    s2.info1();
    Shape.info2();

  }

}
