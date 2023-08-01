package ex01_BankAccount;

public class MainWrapper {

  public static void main(String[] args) {
    
    try {
      BankAccount acc = new BankAccount(10000, "1234");
      BankAccount acc2 = new BankAccount(10000, "5678");
      
//    // 입금
//    acc.deposit(-1);
//    acc.deposit(10000);
//    
//    // 출금
//    long money = acc.withdrawal(30000);
//    System.out.println("출금액 " + money);
//    
//    // 이체
//    acc.transfer(acc2, 1);
//    acc.inquiry();
//    acc2.inquiry();
      
      acc.deposit(10000);
      acc2.withdrawal(5000);
      acc.transfer(acc2, 1);
      acc.inquiry();
      acc2.inquiry();
      } catch(RuntimeException e) {
        System.out.println(e.getMessage());
      }
    
  }

}
