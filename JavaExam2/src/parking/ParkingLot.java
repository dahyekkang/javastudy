package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

  private String name;
  private List<Car> cars = new ArrayList<Car>();
  private final int MAX = 5;
  private Scanner sc = new Scanner(System.in);
  
  public ParkingLot(String name) {
    this.name = name;
  }
  
  public void addCar() {
    
    int size = cars.size();
    System.out.println("현재 등록된 차량 : " + size + "대");
    if(size == MAX) {
      System.out.println("만차입니다. 더 이상 차량 등록이 불가능합니다.");
      return;
    }
    System.out.print("차량번호 입력 >>> ");
    String carNo = sc.next();
    System.out.print("모델 입력 >>> ");
    String model = sc.next();
    cars.add(new Car(carNo, model));
    System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
    
  }
  
  
  public void deleteCar() {
    
    if(cars.isEmpty()) {
      System.out.println("현재 주차장에 등록된 차량이 없습니다.");
      return;
    }
    System.out.print("삭제할 차량번호 입력 >>> ");
    String carNo = sc.next();
    for(int i = 0, size = cars.size(); i < size; i++) {
      if(carNo.equals(cars.get(i).getCarNo())) {
        System.out.println("차량번호 " + cars.get(i).getCarNo() + " 차량이 삭제되었습니다.");
        cars.remove(i);
        return;
      }
    }
    System.out.println("차량번호 " + carNo + " 차량이 존재하지 않습니다.");
    
  }
  
  
  public void searchCar() {
    
    if(cars.isEmpty()) {
      System.out.println("현재 주차장에 등록된 차량이 없습니다.");
      return;
    }
    System.out.print("조회할 차량번호 입력 >>> ");
    String carNo = sc.next();
    for(int i = 0, size = cars.size(); i < size; i++) {
      if(carNo.equals(cars.get(i).getCarNo())) {
        System.out.println("조회 결과: " + cars.get(i));
        return;
      }
    }
    System.out.println("차량번호 " + carNo + " 차량이 존재하지 않습니다.");
  }
  
  public void printAllCars() {
    if(cars.isEmpty()) {
      System.out.println("현재 주차장에 등록된 차량이 없습니다.");
      return;
    }
    System.out.println(name + " 차량 목록");
    for(int i = 0, size = cars.size(); i < MAX; i++) {
      System.out.print(i + 1 + "번째 차량: ");
      if(i < size) {
        System.out.println(cars.get(i));
      } else {
        System.out.println("없음");
      }
    }
  }
  
  public void manage() {
    while(true) {
      System.out.print("1.추가 2.삭제 3.조회 4.전체조회 0.종료 >>> ");
      String choice = sc.next();
      switch(choice) {
      case "1": addCar(); break;
      case "2": deleteCar(); break;
      case "3": searchCar(); break;
      case "4": printAllCars(); break;
      case "0": System.out.println("주차관리 프로그램을 종료합니다."); return;
      default: System.out.println("존재하지 않는 메뉴입니다.");
      }
    }
  }
  
}