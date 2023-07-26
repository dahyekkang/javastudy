package ex01_generic;


// <타입> <- generic이라고 함
// 형태 ! : 클래스명<타입>

public class MainWrapper {

  public static void main(String[] args) {
    
    // String을 저장하는 box1
    Box<String> box1 = new Box<String>();  // 스트링(문자열의 참조타입)을 저장할 수 있는 박스

    // 호출하면서 과정을 보자!
    box1.setItem("Hello World !");
    System.out.println(box1.getItem());   // 반환 타입이 String으로 되어있음~~!
    
    // int를 저장하는 box2
    // 오직 "참조타입"만 Generic 처리에서 사용할 수 있다.
    
    // int를 저장할 때 사용하는 참조 타입 : Integer
    // int의 참조타입인 Integer를 사용한다.
    Box<Integer> box2 = new Box<Integer>();     // Integer(정수의 참조타입)를 저장할 수 있는 박스
    
    // 호출하면서 과정을 보자!
    box2.setItem(2);
    System.out.println(box2.getItem());
    
    // 참조타입 *Short, Float은 제외됨* : Boolean, Byte, Character, Integer, Long, Double 등 -> Wrapper Class라고 부름 
    
    // Person을 저장하는 box3
    Box<Person> box3 = new Box<Person>();
    
    box3.setItem(new Person("강다혜"));
    System.out.println(box3.getItem());
    
  }

}
