package ex05_BankAccount;

public class BankMember {
  
  private String name;
  private BankAccount acc;
  
  
  public BankMember(String name, BankAccount acc) {
    this.name = name;
    this.acc = acc;
  }


  // setter와 getter 이용하여 반환
  public BankMember() {
    
  }

  // Setter
  public void setName(String name) {
    this.name = name;
  }

  public void setAcc(BankAccount acc1) {
    this.acc = acc1;
  }
  
  // Getter
  public String getName() {
    return name;
  }
  
  public BankAccount getAcc() {
    return acc;
  }
  
  // BankMember 정보 출력
  public void info() {
    System.out.println("고객명 : " + name);
    acc.info();
  }
}