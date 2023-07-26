package ex09_Eatable;

public class AppleMango extends Food implements Eatable {

  public AppleMango(String name) {
    super(name);    // 슈퍼 클래스의 pulic Food(String name) { } 생성자 호출
    // 상속관계에 있는 자식은 부모가 먼저 호출되어야 함.
  }
  
}
