package ex08_Bakery;

public class BreadChange {
  
  private int bread;    // 판매한 빵의 갯수
  private int change;   // 잔돈
  
  public BreadChange(int bread, int change) {
    this.bread = bread;
    this.change = change;
  }
  
  public int getBread() {
    return bread;
  }
  public void setBread(int bread) {
    this.bread = bread;
  }
  
  public int getChange() {
    return change;
  }
  
  public void setChange(int change) {
    this.change = change;
  }
  
}
