package ex01_generic;

// 만능 박스를 만드는 것이 목표 !
// T는 고정은 아니고, 적절한 대문자를 사용하는 것이 일반적
// 중요한 것은 박스 사용 방법! MainWrapper.

public class Box<T> {

  private T item;   // String이 T로 바뀌어서 private String item인 것임. 모든 T가 String으로 바뀐 상태로 해석이 됨.

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
  
  
}
