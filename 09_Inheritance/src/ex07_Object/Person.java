package ex07_Object;

import java.util.Objects;

/*
 * java.lang.Object 클래스
 * 1. 모든 클래스의 최상위 슈퍼 클래스이다.
 * 2. 별도의 슈퍼 클래스를 명시하지 않은 클래스들은(extends가 없는 클래스) 모두 Object 클래스의 서브 클래스이다.
 * 3. 모든 것을 저장할 수 있는 Java의 만능 타입이다.
 * 4. Object 타입으로 저장하면 Object 클래스의 메소드만 호출할 수 있다. 이를 해결하기 위해서 "반드시" 캐스팅을 해야 한다.
 */

/*
 * 객체비교는 equals()메소드라는 이름을, 문자열반환은 toString()메소드라는 이름을 사용할 것!이라는 작업지시서임
 *  ┌--------------┐
 *  │  Object      │ 슈퍼 클래스
 *  │--------------│
 *  │  equals()    │ 두 객체의 참조값을 비교해서 같으면 true, 아니면 false 반환
 *  │  getClass()  │ 어떤 클래스인지 반환
 *  │  hashCode()  │ int 타입의 해시코드값, Object 클래스는 객체의 참조값을 해시코드값으로 사용함
 *  │  toString()  │ "클래스이름@참조값" 형식의 문자열을 반환
 *  │  notify()    │ 스레드(thread) 관련 메소드
 *  │  wait()      │ 스레드(thread) 관련 메소드
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │  Person      │ 서브 클래스
 *  │--------------│
 *  │  @Override   │
 *  │  equals()    │ 이름과 나이가 같으면 true, 아니면 false 반환 (하드코딩하지 않고, 자동완성한다.)
 *  │              │
 *  │  @Override   │
 *  │  toString()  │ 이름과 나이를 확인할 수 있는 문자열 반환 (하드코딩하지 않고, 자동완성한다.)
 *  └--------------┘
 *  
 *  equals랑 toString은 이걸 쓰라는게 아니고 이걸 다시 만들어서 쓰라는 것임(Source의 자동완성 후 수정)
 */

/*
 * equals() : 두 객체의 참조값을 비교해서 같으면 true, 아니면 false 반환
 * -> String은 ==로 비교할 수 없기 때문에(== 는 값이 아닌 주소 값을 비교) equals를 오버라이드해서 다시 만들어서 사용해라 ! ! !
 * toString() : 이름과 나이를 확인할 수 있는 문자열 반환할 수 있게끔 오버라이드
 * 
 * this : 참조값
 */

public class Person {
  
  private java.lang.String name;
  private int age;
  
  // new Person()
  public Person() {
    
  }
  
  // new Person("강다혜", 20)
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  
  // 직접 만든 equals (지우라고 하셨움)
  // Object 클래스에 커서 가져다 댄 뒤 ctril + 클릭 하면 Object class 설명란이 나오는데 거기서 찾아서 참고함
//  @Override
//  public boolean equals(Object obj) {   // p1.equals(p2)
//    Person p = (Person)obj;   // 다운캐스팅! , p가 p2임
////    name == p.name // String의 경우에는 이렇게 비교하면 안 됨 !
////    name.equals(p.name);
//    return(age == p.age) && name.equals(p.name);
//// age는 필드의 age이며, 여기에선 p1의 age를 의미! p.age는 p2의 age이다.
//// name은 String이므로 .equals 사용해야 함
//  }
  
  
  
  
  
  // eclipse가 자동완성 시켜준 equals 해쉬코드 & equals 메소드
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)    // p1.equals(p1)
      return true;
    if (obj == null)    // p1.equals(null)
      return false;
    if (getClass() != obj.getClass())   // p1.equals(s1) : person과 student 비교, 클래스가 다르면 비교할 필요도 없다!
      return false;
    Person other = (Person) obj;
    return age == other.age && Objects.equals(name, other.name);
  }
  
  // 직접 만든 toString() ! 지우라고 하셨움
//  @Override
//  public String toString() {
//    return name + ", " + age;
//}
  
  // eclipse가 자동완성 시켜준 toString()
    @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  
  

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }

}
