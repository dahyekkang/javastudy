package ex07_Object;

public class MainWrapper {
  
  public static void ex01() {
    
    // Object 타입으로 모든 객체를 저장할 수 있다.
    // Object 타입으로 저장한 객체를 사용할 때는 다운캐스팅 해야 한다.    
    Object obj = new Person();
    ((Person)obj).setName("강다혜");
    ((Person)obj).setAge(20);
    java.lang.System.out.println(((Person)obj).getName());
    System.out.println(((Person)obj).getAge());
  }
  
  public static void ex02() {
    
    // 동일한 객체 2개
    Person p1 = new Person("강다혜", 20);
    Person p2 = new Person("강다혜", 20);
    
    // 동일한 객체인지 판단
     boolean same = p1.equals(p2);
     
     // 결과 확인
     System.out.println(same ? "동일한 객체" : "다른 객체");
  }
  
  public static void ex02_1() {
    
    // 정처기 실기 시험 틀린 것.... 일주일만 일찍 알려주시지 ㅠㅠㅠㅠㅠㅠㅠㅠ
    String str1 = "프로그래밍"; // true or false
    String str2 = "프로그래밍";
    String str3 = new String("프로그래밍");

    
    System.out.println(str1==str2);
    System.out.println(str1==str3);
    System.out.println(str1.equals(str2));
    System.out.println(str1.equals(str3));
    System.out.println(str2.equals(str3));

  }

  public static void ex03() {
    
    Person p = new Person("강다혜", 20);
    
    System.out.println(p);    // 객체 p는 p.toString()이 자동 호출돼서 사용된다.
    // System.out.println(p.toString());
    
  }

  public static void main(String[] args) {

    ex03();
    
  }

}
