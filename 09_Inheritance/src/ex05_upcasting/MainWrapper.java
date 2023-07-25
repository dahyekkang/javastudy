package ex05_upcasting;

/*
 * upcasting
 * 1. 서브 클래스 객체를 슈퍼 클래스 타입으로 저장할 수 있다.
 * 2. 강제로 캐스팅(형변환)할 필요가 없다. 자동으로 변환된다.
 * 3. 장점
 *    1) 슈퍼 클래스 타입으로 모든 서브 클래스 객체를 저장할 수 있다.
 *    2) 서로 다른 타입의 객체를 하나의 타입으로 관리할 수 있다.
 * 4. 단점
 *    1) 슈퍼 클래스 타입으로 저장하기 때문에 슈퍼 클래스의 메소드만 호출할 수 있다. -> 학생인데 공부를 못 해
 *    2) 이 단점을 해결하기 위해서 메소드 오버라이드(method override)를 이용할 수 있다.
 */

public class MainWrapper {

  public static void main(String[] args) {
/*    
    Student s1 = new Student();
    s1.setName("강다혜");
    s1.setSchool("가산대학교");
    s1.eat();
    s1.sleep();
    s1.study();
    System.out.println(s1.getName());
    System.out.println(s1.getSchool());
    s1.info();
    
    Student s2 = new Student("강다혜", "가산대학교");
    s2.eat();
    s2.sleep();
    s2.study();
    System.out.println(s2.getName());
    System.out.println(s2.getSchool());
 */
  
    Person p1 = new Student("강선혜", "금천대학교");
    //Alba alba = new Alba("강다혜", "가산대학교", "투썸");
    Person p2 = new Alba("강다혜", "가산대학교", "투썸");
    //alba.info();
    
    p1.eat();
    p1.sleep();
    p1.study();
    
    p2.eat();
    p2.sleep();
    p2.study(); // Person의 study() 호출 -> Student의 study() 실행
    p2.working();
    
  }

}
