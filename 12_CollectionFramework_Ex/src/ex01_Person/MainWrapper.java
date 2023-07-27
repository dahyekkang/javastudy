package ex01_Person;

import java.util.ArrayList;
import java.util.List;

public class MainWrapper {

  public static void main(String[] args) {
    
    List<Person> family = new ArrayList<Person>();
    
    // 가족 모두 저장하고 for문으로 확인하기
    family.add(0, new Person("강용철", 58));
    family.add(1, new Person("이지연", 54));
    family.add(2, new Person("강선혜", 28));
    family.add(3, new Person("강다혜", 26));
    family.add(4, new Person("강진석", 24));
    family.add(5, new Person("모모", 15));
    family.add(6, new Person("미미", 12));
    family.add(7, new Person("모리", 2));
    family.add(8, new Person("물꼬기들", 1));
    
    for(int i = 0, length = family.size(); i < length; i++) {
      System.out.println(family.get(i));    // Person의 toString() 동작
      System.out.println("이름 : " + family.get(i).getName());
      System.out.println("나이 : " + family.get(i).getAge());
    }
  }

}
