package ex06_Member;

public class MainWrapper {

  public static void main(String[] args) {
    
    Address address = new Address();
    // 정보 추가 (Setter 활용)
    address.setPostCode("0707");
    address.setRoadAddr("보라매로 5길");
    address.setJibunAddr("신대방동 39-6");
    address.setDetailAddr("310호");
    
    Contact contact = new Contact();
    // 정보 추가 (Setter 활용)
    contact.setHomeTel("02-374-23");
    contact.setMobile("010-375-03");
    contact.setAddress(address);
    
    Member member = new Member();

    member.setName("강다혜");
    member.setContact(contact);
    
    // Member member 객체 정보 확인 (Getter 활용)
    //member.info();
    System.out.println("이름 : " + member.getName());
    System.out.println("집전화번호 : " + member.getContact().getHomeTel());
    System.out.println("휴대폰번호 : " + member.getContact().getMobile());
    System.out.println("우편번호: " + member.getContact().getAddress().getPostCode());
    System.out.println("도로명주소 : " + member.getContact().getAddress().getRoadAddr());
    System.out.println("지번주소 : " + member.getContact().getAddress().getJibunAddr());
    System.out.println("상세주소 : " + member.getContact().getAddress().getDetailAddr());
    
  }
  
}
