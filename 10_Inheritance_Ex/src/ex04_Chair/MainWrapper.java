package ex04_Chair;

public class MainWrapper {

  public static void main(String[] args) {
    
    Chair chair1 = new Chair();
    chair1.setPerson(new Student("강다혜", "가산대학교"));
    chair1.getPerson().info();    // 이름, 학교 출력
    
    Chair chair2 = new Chair();
    chair2.setPerson(new Alba("강선혜", "금천대학교", "투썸"));
    chair2.getPerson().info();    // 이름, 학교, 직장 출력
  }

}
