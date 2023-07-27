package ex03_Bus;

public class MainWrapper {

  public static void main(String[] args) {

    Bus bus = new Bus();
    
    bus.getOn(1, new Person("가다혜"));     // 첫 좌석
    //bus.getOn(25, new Student("나다혜"));   // 마지막 좌석
    //bus.getOn(25, new Student("다다혜"));   // 이미 앉은 좌석
    //bus.getOn(30, new Student("라다혜"));   // 오류 메시지 출력

    System.out.println();
    
    bus.getOff(1);
    //bus.getOff(10);   // 오류 메시지 출력
    //bus.getOff(30);   // 오류 메시지 출력
    
    bus.getOff(1);
    bus.getOn(1, new Person("마다혜"));
    
    System.out.println();
    
    bus.info();   // 전체 좌석 출력
  }

}
