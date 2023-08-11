package ex03_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainWrapper {
  
  /*
   *  ┌--------------┐
   *  │     Set      │ Set 인터페이스
   *  │--------------│
   *  │   add();     │
   *  │   size();    │
   *  │   remove();  │
   *  └--------------┘
   *          ▲
   *          │
   *          │
   *  ┌--------------┐
   *  │   HashSet    │ HashSet 클래스
   *  │--------------│
   *  │   add(){}    │ 요소 추가하기
   *  │   size(){}   │ 요소 개수 반환하기
   *  │   remove(){} │ 요소 삭제하기
   *  └--------------┘
   */
  
  /*
   * Set
   * 1. 인덱스가 없다. 저장 순서가 없다.
   * 2. 중복 저장이 되지 않는다.
   */

  public static void ex01() {
    
    // Set 인터페이스 타입 선언
    Set<String> season;
    
    // HashSet 클래스 객체 생성
    season = new HashSet<String>();
    
    // 요소 추가하기
    season.add("봄");
    season.add("여름");
    season.add("가을");
    season.add("겨울");
    season.add("봄");
    
    // 전체 확인하기
    System.out.println(season);
  }

  public static void ex02() {
    
    // HashSet 선언 & 생성
    Set<String> hobbies = new HashSet<String>();
    
    // 요소 저장하기
    hobbies.add("베이킹");
    hobbies.add("유튜브");
    hobbies.add("여행");
    hobbies.add("코딩");
    
    // for문 활용하기 (인덱스가 없으므로 향상 for문)
    for(String hobby : hobbies) {
      System.out.println(hobby);
    }
    
  }
  
  public static void ex03() {
    
    // HashSet 선언 & 생성
    Set<String> flower = new HashSet<String>();
    
    // 요소 저장하기
    flower.add("개나리");
    flower.add("장미");
    flower.add("프리지아");
    flower.add("민들레");
    
    // 반복자 Iterator를 이용한 Set 순회
    Iterator<String> arm = flower.iterator();   // 플라워 세트에 집어넣을 수 있는 팔을 하나 만들자.
   
   // 조건 : arm.hasNext()
    // 실행 : System.out.println(arm.next())
    
    while(arm.hasNext()) {
      System.out.println(arm.next());
    }
    
  }
  
  public static void ex04() {

    // 동일한 객체 2개
    Person p1 = new Person("강다혜", 26);
    Person p2 = new Person("강다혜", 26);
    
    // HashSet 선언 & 생성
    Set<Person> people = new HashSet<Person>();
    
    // 요소 추가
    people.add(p1);
    people.add(p2);
    
    // 확인
    System.out.println(people);
    
    // Hash Set은 p1과 p2의 참조값을 비교한 후 중복 여부를 판단하므로 p1과 p2가 같지 않은 것이라고 판단한다. -> Person에 equals를 오버라이드하면 됨!
    
  }
  
  public static void ex05() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1,2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 교집합
    set1.retainAll(set2);  // 교집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [3, 4, 5]
    
  }
  
  public static void ex06() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 합집합
    set1.addAll(set2);  // 합집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [1, 2, 3, 4, 5, 6, 7]
    
  }
  
  public static void ex07() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 차집합
    set1.removeAll(set2);  // 차집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [1, 2]
    
  }
  
  
  public static void main(String[] args) {
    
    ex04();

  }

}
