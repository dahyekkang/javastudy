package ex06_Member;

public class Member {
  
  private String name;      // 이름
  private Contact contact;  // 번호(Contact class)
  
  
  // 이름
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  
  // 번호
  public Contact getContact() {
    return contact;
  }
  public void setContact(Contact contact) {
    this.contact = contact;
  }
  

//  public void info() {
//    System.out.println("고객명 : " + name);
//    contact.info();
//  }
  

}
