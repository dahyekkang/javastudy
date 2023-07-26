package ex08_abstract;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 아래의 추상 클래스 Person은 객체를 생성할 수 없다. Person을 추상 클래스로 바꾼 후에 아래쪽 객체 생성했던 Person에 오류가 난다. -> 지워버려라!
//    Person p1 = new Person();
//    p1.eat();
//    p1.sleep();
    
    Person p2 = new Student(); 
    p2.eat();
    p2.sleep();
    //p2.study(); // 현재 안 됨 (Person타입이므로 Person에 있는 것만 가능하므로 오버라이드 필수로 진행해 주어야 함. 오버라이드 후엔 실행이 됨)
    p2.study();   // 오버라이드를 했기 때문에 실행 됨
  }

}
