package ex05_BankAccount;

public class Bank {
  
  private String name;  // 필드는 일반변수와 다르게 자동 초기화(초깃값 null)
  private String tel;

  // 생성과 동시에 값을 채워주는 생성자
  public Bank(String name, String tel) {  // 파라미터가 있는 생성자
    this.name = name;
    this.tel = tel;
  }
  
  // setter와 getter 이용하여 반환(디폴트 생성자 필요)
  // 이름이 같은 메소드이지만 파라미터가 다르면 존재할 수 있다. : 메소드 오버로딩
  public Bank() {
    
  }

  // Setter
  public void setName(String name) {
    this.name = name;
  }
  
  public void setTel(String tel) {
    this.tel = tel;
  }
  
  // Getter
  public String getName() {
    return name;
  }
  
  public String getTel() {
    return tel;
  }  
  
  // Bank 정보 출력
  public void info() {
    System.out.println(name + "(" + tel + ")");
  }
  
}
