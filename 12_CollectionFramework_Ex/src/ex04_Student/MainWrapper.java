package ex04_Student;

import java.util.HashMap;
import java.util.Map;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 교실의 학생 정보를 저장하는 HashMap 만들기
    Map<Integer, Student> clazz = new HashMap<Integer, Student>();
    
    // Key   : 학번(예: 10101)
    // Value : Student 객체
    clazz.put(10101, new Student("강다혜", new Exam(100, 100, 100)));
    clazz.put(10102, new Student("모모", new Exam(90, 90, 90)));
    clazz.put(10103, new Student("미미", new Exam(80, 80, 80)));
    clazz.put(10104, new Student("모리", new Exam(70, 70, 70)));
    clazz.put(10105, new Student("물고기", new Exam(60, 60, 50)));
    
    Student student = new Student();
    student.setName("거북이");
    student.setExam(new Exam(40, 70, 80));
    clazz.put(10106, student);
    
    Integer[] stuNo = {10101, 10102, 10103, 10104, 10105, 10106};
    for(int i = 0; i < stuNo.length; i++) {
      Student student1 = clazz.get(stuNo[i]);
      System.out.println("이름 : " + student1.getName());
      System.out.println("시험 : " + student1.getExam());
    }
    
    
  }

}
