package ex05_BankAccount;

public class MainWrapper {

  public static void main(String[] args) {

    Bank bank = new Bank("국민은행가산지점", "02-111-1111");
    bank.info();  // 국민은행가산지점(02-111-1111)

    BankAccount acc = new BankAccount(bank, "012-34-56789", 50000);
    acc.info();  // 계좌번호: 012-34-56789, 통장잔액: 50000원
                 // 개설지점: 국민은행가산지점(02-111-1111)
    
    BankMember member = new BankMember("홍길동", acc);
    member.info();  // 고객명: 홍길동
                    // 계좌번호: 012-34-56789, 통장잔액: 50000원
                    // 개설지점: 국민은행가산지점(02-111-1111)
  
    Bank bank1 = new Bank();    // 인수가 없는 생성자
    bank1.setName("우리은행");
    bank1.setTel("02-222-2222");
    
    BankAccount acc1 = new BankAccount();
    acc1.setBank(bank1);
    acc1.setAccNo("012-34-56789");
    acc1.setBalance(10000);
    
    BankMember member1 = new BankMember();
    member1.setName("상철");
    member1.setAcc(acc1);
    
    System.out.println("고객명: " + member1.getName());
    System.out.println("계좌번호: " + member1.getAcc().getAccNo());
    System.out.println("통장잔액: " + member1.getAcc().getBalance());
    System.out.println("개설지점: " + member1.getAcc().getBank().getName());
    System.out.println("지점연락처: " + member1.getAcc().getBank().getTel());
    
  }
  
}