package ex06_downcasting;

public class MainWrapper {
  
  public static void ex01() {
    Person p = new Student(); // upcasting, Student객체 p의 타입을 Person으로 하겠다. ( 서브 클래스 객체 의 타입을 슈퍼 클래스의 타입으로하겠다 )  
    p.eat();
    p.sleep();
    ((Student)p).study();    // 슈퍼 클래스 타입 -> 서브 클래스 타입으로 변경(다운캐스팅)
    ((Worker)p).work();      // 잘못된 캐스팅을 막고 싶다!    
  }
  
  public static void ex02() {
    
    Person p1 = new Student();
    System.out.println(p1 instanceof Person);    // p1이 Person  타입이면 true, 아니면 false
    System.out.println(p1 instanceof Student);   // p1이 Student 타입이면 true, 아니면 false
    System.out.println(p1 instanceof Worker);    // p1이 Worker  타입이면 true, 아니면 false
    
    Person p2 = new Worker();
    System.out.println(p2 instanceof Person);    // p2가 Person  타입이면 true, 아니면 false
    System.out.println(p2 instanceof Student);   // p2가 Student 타입이면 true, 아니면 false
    System.out.println(p2 instanceof Worker);    // p2가 Worker  타입이면 true, 아니면 false
   
  
  }
  
  public static void ex03() {
    Person p1 = new Student();
    if(p1 instanceof Student) {
      ((Student)p1).study();    // instanceof 사용 시 코드 자동완성도 해줌(p1. + )
    }
    
    Person p2 = new Worker();
    if(p2 instanceof Worker) {
      ((Worker) p2).work();
    }
  }

  public static void main(String[] args) {
    ex02();
  }

}
