package ex05_BankAccount;

public class BankAccount {
  
  private Bank bank;
  private String accNo;
  private long balance;
  
  public BankAccount(Bank bank, String accNo, long balance) {
    this.bank = bank;
    this.accNo = accNo;
    this.balance = balance;
  }
  
  // setter와 getter 이용하여 반환(디폴트 생성자 필요)
  // setter와 getter 이용하여 반환
  public BankAccount() {    // 디폴트 생성자 생성
    
  }
  
  // Setter
  public void setBank(Bank bank) {
    this.bank = bank;
  }
  
  public void setAccNo(String accNo) {
    this.accNo = accNo;
  }
  
  public void setBalance(long balance) {
    this.balance = balance; 
  }
  
  // Getter
  public Bank getBank() {
    return bank;
  }
  
  public String getAccNo() {
    return accNo;
  }
  
  public long getBalance() {
    return balance;
  }
  
  
  // BankAccount 정보 출력
  public void info() {
    System.out.println("계좌번호 : " + accNo + ", " + "통장잔액 : " + balance + "원");
    System.out.print("개설지점 : ");
    bank.info();
  }
  
  // 입금 메소드
  public void deposit(long money) {
    if(money <= 0) {
      return;
    }
    balance += money;
  }
  
  // 출금 메소드
  public long withdrawal(long money) {
    long retVal = 0;
    if(money > 0 && money <= balance) {
      balance -= money;
      retVal = money;
      }
    return retVal;
  }
  
  // 이체 메소드
  public void transfer(BankAccount acc, long money) {
    acc.deposit(withdrawal(money));
  }
  
}
