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
  
  // 이체 메소드 호출을 위한 작업
  // 입금 메소드
  public void deposit(long money) {
    acc.deposit(money);
  }
  
  // 출금 메소드
  public long withdrawal(long money) {
    return acc.withdrawal(money);
  }
  
  //이체 메소드
  public void transfer(BankMember member, long money) {
    member.deposit(withdrawal(money));
  }
  
}