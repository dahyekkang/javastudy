package ex08_abstract;

/*
 * 추상 클래스
 * 1. 추상 메소드를 1개 이상 가지고 있는 클래스이다.
 * (study 메소드 때문에 더이상 일반 클래스가 아닌 추상 클래스가 된다.)
 * 2. abstract 키워드를 추가한다.
 * 3. 추상 클래스는 객체를 생성할 수 없다. (미완성 된 클래스이기 때문이다.)
 * 4. 추상 클래스의 서브 클래스는 "반드시" 추상 메소드를 오버라이드 해야 한다.
 * 중요한 특징 : 3, 4번!!!!!!!!!
 */

//public class Person { -> 추상클래스-2번.여기서 abstract 추가해야함(추상클래스이기때문에)
public abstract class Person {
  
  public void eat() {
    System.out.println("냠냠");
  }
  public void sleep() {
    System.out.println("쿨쿨");
  }
  
  // 호출을 위해서 생성한 study
  // 본문이 필요 없기 때문에 본문이 없는 메소드로 만들 수 있다.
  // 본문이 없는 메소드를 "추상 메소드"라고 한다.
  // abstract 키워드를 추가하고 본문({})을 제거한다.
  // public 앞 or public 뒤에 키워드 추가 가능. 일반적으로는 public 뒤에 한다.
//  public void study() {
//    
//  }
  public abstract void study(); // 여기까지 하면 Person과 study에 오류가 나는데 이는 추상클래스의 설명에서 설명하겠다! 위에!!

  
  // GameUnit으로 가서 추상으로 바꿀 수 있는 것 바꾸기!!! attack..해보셈
}
