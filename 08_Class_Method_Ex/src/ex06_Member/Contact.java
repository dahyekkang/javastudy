package ex06_Member;

public class Contact {
  
  private String homeTel;   // 집 전화번호
  private String mobile;    // 휴대폰번호
  private Address address;  // 주소(Address class)


  // 집 전화번호
  public String getHomeTel() {
    return homeTel;
  }
  public void setHomeTel(String homeTel) {
    this.homeTel = homeTel;
  }
  
  // 휴대폰 번호
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  
  // 주소
  public Address getAddress() {
    return address;
  }  
  public void setAddress(Address address) {
    this.address = address;
  }
  
  
//  public void info() {
//    System.out.println("집 전화번호 : " + homeTel);
//    System.out.println("휴대폰번호 : " + mobile);
//    address.info();
//  }
  
}
