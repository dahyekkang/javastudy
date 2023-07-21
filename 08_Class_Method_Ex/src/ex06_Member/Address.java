package ex06_Member;

public class Address {

  private String postCode;    // 우편 번호
  private String roadAddr;    // 도로명 주소
  private String jibunAddr;   // 지번 주소
  private String detailAddr;  // 상세 주소

  
  // 우편 번호
  public String getPostCode() {
    return postCode;
  }
  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
  
  // 도로명 주소
  public String getRoadAddr() {
    return roadAddr;
  }
  public void setRoadAddr(String roadAddr) {
    this.roadAddr = roadAddr;
  }
  
  // 지번 주소
  public String getJibunAddr() {
    return jibunAddr;
  }
  public void setJibunAddr(String jibunAddr) {
    this.jibunAddr = jibunAddr;
  }

  // 상세 주소
  public String getDetailAddr() {
    return detailAddr;
  }
  public void setDetailAddr(String detailAddr) {
    this.detailAddr = detailAddr;
  }
  
  
//  public void info() {
//    System.out.println("우편번호 : " + postCode);
//    System.out.println("도로명 주소 : " + roadAddr);
//    System.out.println("지번 주소 : " + jibunAddr);
//    System.out.println("상세 주소 : " + detailAddr);
//    
//  }

  
}
