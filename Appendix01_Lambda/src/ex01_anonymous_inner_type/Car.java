package ex01_anonymous_inner_type;

public interface Car {
  
  void addOil(); // public abstract void addOil(); 인터페이스의 추상 메소드는 이렇게 알아서 들어감
  // 형태가 없기 때문에 객체로 만들 수 없다.
  // 본문을 만들면 인터페이스도 new를 만들 수 있다.

}
