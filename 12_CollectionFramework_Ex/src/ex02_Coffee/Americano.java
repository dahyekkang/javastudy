package ex02_Coffee;

public class Americano implements Coffee {    // 아메리카노는 타입이 아메리카노, 커피! 두 개 다 가능

  private String name;

  public Americano(String name) {
    super();
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public String toString() {
    return "Americano [name=" + name + "]";
  }
  
}
