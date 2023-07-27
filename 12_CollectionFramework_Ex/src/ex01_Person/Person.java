package ex01_Person;

public class Person {
  
  private String name;
  private int age;
  
  public Person() {
    
  }
  
  // 메소드 자동 완성!( Person(String name, int age), getName, setName, toString)
  public Person(String name, int age) {
    super();            // object생성자를 부름
    this.name = name;
    this.age = age;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  

}
