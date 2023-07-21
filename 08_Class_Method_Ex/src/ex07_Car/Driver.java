package ex07_Car;

public class Driver {

  private String name;          // 운전자명
  private int career;           // 운전경력
  private boolean bestDriver;   // 베스트 드라이버 기준 career가 10년 이상이면 true
  
  // 운전자명
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  // 운전경력
  public int getCareer() {
    return career;
  }
  public void setCareer(int career) {
    this.career = career;
    setBestDriver(career >= 10);
  }
  
  // 베스트 드라이버 -> boolean타입의 getter는 get객체명이 아니라 is객체명
  public boolean isBestDriver() {
    return bestDriver;
  }
  private void setBestDriver(boolean bestDriver) {
    this.bestDriver = bestDriver;
  }
  
}
