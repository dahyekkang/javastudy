package ex02_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  ┌--------------┐
 *  │     List     │ List 인터페이스
 *  │--------------│
 *  │   add();     │
 *  │   get();     │
 *  │   size();    │
 *  │   set();     │
 *  │   remove();  │
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │   ArrayList  │ ArrayList 클래스
 *  │--------------│
 *  │   add(){}    │ 요소 추가하기
 *  │   get(){}    │ 요소 가져오기
 *  │   size(){}   │ 요소 개수 반환하기
 *  │   set(){}    │ 요소 수정하기
 *  │   remove(){} │ 요소 삭제하기
 *  └--------------┘
 */

public class MainWrapeer {
  
  public static void ex01() {
    
//    // ArrayList의 인터페이스 List 타입 선언
//    List<String> season;
//    
//    // ArrayList 생성
//    season = new ArrayList<String>();
//    
//    // 배열 요소 추가하기
//    season.add("여름");   // 인덱스 0에 여름 추가됨
//    season.add("가을");
//    season.add("겨울");
//    season.add(0, "봄");  // 인덱스 0에 봄이 들어가고 나머지 애들 한 칸씩 미룸
//    
//    // 배열 요소 확인하기(get 메소드 사용)
//    System.out.println(season.get(0)); // 첫번째 요소 가져오기
//    System.out.println(season.get(1)); // 두번째 요소 가져오기
//    System.out.println(season.get(2)); // 세번째 요소 가져오기
//    System.out.println(season.get(3)); // 네번째 요소 가져오기
    
    
    for(String element : season) {
      System.out.println(element);
    }
    
    String[] season = new String[4];
    season[0] = "여름";
    season[1] = "가을";
    season[2] = "겨울";
    System.arraycopy(season, 0, season, 1, 3);
    season[0] = "봄";
    // 이렇게 해야하는데 이거 대신 ArrayList를 쓰면 편함
    
  }

  public static void ex02() {
    
    // ArrayList의 선언 & 생성
    List<String> hobbies = new ArrayList<String>(); 
    // 타입은 List, 저장할 리스트의 타입은 String
    
    // 배열 요소 추가하기
    hobbies.add("여행");
    hobbies.add("유튜브");
    hobbies.add("코딩");
    
    // 배열의 길이 확인하기 (저장된 요소의 갯수)
    System.out.println(hobbies.size());
    
//    지금까지 나온 메소드~~
//    add() : 추가할 때 쓰는 것
//    get() : 뽑을 때 쓰는 것
//    size(): 배열의 길이 확인할 때 쓰는 것
// 마지막 요소의 인덱스는 길이 - 1이다! 연습해보자.
    
    // 배열 길이 관련 (마지막 요소 꺼내기)
    System.out.println(hobbies.get(hobbies.size()-1));
    
    // 배열 for문 적용하기
    for(int i = 0; i < hobbies.size(); i++) {
      System.out.println(hobbies.get(i));
    }
    
    // 배열 for문 적용하기 (리팩토링 : hobbies.size() 메소드가 여러 번 호출되는 문제 해결)
    for(int i = 0, length = hobbies.size(); i < length; i++) {
      System.out.println(hobbies.get(i));
    }  
    
  }

  public static void ex03() {
    
    // ArrayList 선언 & 생성
    List<String> flower = new ArrayList<String>();
    
    // 요소 추가하기
    flower.add("장미");
    flower.add("튤립");
    flower.add("무궁화");
    
    // 요소 수정하기
    flower.set(0, "해바라기");    // 인덱스 0의 요소를 "해바라기"로 수정
    
    // 요소 삭제하기
    flower.remove(2);         // 인덱스 2의 요소를 삭제
   
    // for문
    for(int i = 0, length = flower.size(); i < length; i++) {
      System.out.println(flower.get(i));
    }
  }
  
  public static void ex04() {
    
    // 배열을 ArrayList로 바꾸기 ( java.util패키지의 Arrays 이용)
//    int[] a = {10, 20, 30, 40, 50};
//    List<Integer> numbers = Arrays.asList(a); // List는 Integer로 되어있는데 a의 타입은 int이기 때문에 오류가 난다. 타입을 맞추어주어야함
    
    Integer[] a = {10, 20, 30, 40, 50};
    List<Integer> numbers = Arrays.asList(a);
    
    // 주의!!!!!!!!!!!!! 초기화된 ArrayList는 길이를 변경할 수 없다.
    // numbers.add(60);    // exception 발생! (불가능)
    // numbers.remove(1);     // exception 발생! (불가능)
    
    // for문
    for(int i = 0, length = numbers.size(); i < length; i++) {
      System.out.println(numbers.get(i));
    }
    
  }
  
  public static void ex05() {
    
    // ArrayList 초기화
    List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
    
    // for문
    for(int i = 0, length = numbers.size(); i < length; i++) {
      System.out.println(numbers.get(i));
    }
    
  }
  
  public static void main(String[] args) {
    
    ex01();

  }

}
