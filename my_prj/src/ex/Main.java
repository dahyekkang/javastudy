package ex;

class Test{
  
  static int classVar = 10;   // 클래스 변수 선언 및 초기화 (인스턴스들이 공유하는 하나의 변수)
  int instanceVar = 20;       // 인스턴스 변수 선언 및 초기화
  
}

public class Main{
  
  public static void main(String[] args) {
    
    Test test1 = new Test();    // test1 객체(인스턴스) 생성
    
    System.out.println("=== Test1 ===");
    System.out.println("test1.class : " + Test.classVar + "\t test1.instance : " + test1.instanceVar);
    
    Test.classVar = 30;        // test1의 클래스 변수 값 할당
    test1.instanceVar = 40;     // test1의 인스턴스 변수 값 할당
    
    System.out.println();
    System.out.println("=== Test1 ===");
    System.out.println("test1.class : " + Test.classVar + "\t test1.instance : " + test1.instanceVar);
    
    Test test2 = new Test();    // test2 객체 생성
    
    System.out.println("=== Test2 ====");
    System.out.println("test2.class : " + Test.classVar + "\t test2.instance : " + test2.instanceVar);
    
  }

}



