package ex07_Car;

public class Car {
  
  private Driver driver;  // 운전자
  private int speed;      // 현재 속도
  private int fuel;       // 남은 연료
  private final int MAX_SPEED = 100;  // 최대 속도
  private final int MIN_SPEED = 0;    // 최저 속도
  

  
  public Driver getDriver() {
    return driver;
  }
  public void setDriver(Driver driver) {
    this.driver = driver;
  }
  
  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }
  
  public int getFuel() {
    return fuel;
  }
  public void setFuel(int fuel) {
    this.fuel = fuel;
  }
  
  // getter에서 get 대신 is 사용하지만 객체명이 is로 시작하는 경우 is는 한 번만 기재

  
  public void engineStart() {
    if(fuel == 0) {
      System.out.println("시동이 걸리지 않았습니다.");
    } else {
      System.out.println("시동이 걸렸습니다.");
    }
  }
  
  public void drive() {
    if(fuel == 0 || driver == null) {
      System.out.println("자동차가 움직이지 않았습니다.");
    } else {
      System.out.println("자동차가 움직였습니다.");
    }
  }
  
  public void accel(int speed) {
    this.speed += speed;
    fuel--;
    if(this.speed >= MAX_SPEED) {
      this.speed = MAX_SPEED;
      }
    System.out.println("현재 속도는 " + this.speed + "입니다.");
  }
  
  public void brake(int speed) {
    this.speed -= speed;
    this.speed = (this.speed <= MIN_SPEED ? this.speed = MIN_SPEED : this.speed);
    System.out.println("현재 속도는 " + this.speed + "입니다.");
  }
  
}
