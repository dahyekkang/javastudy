package ex05_access_modifier;

public class MainWrapper {
  
  public static void main(String[] args) {
    
    User u = new User();
    
    u.setId("kdh");
    System.out.println(u.getId());
    
    u.setAge(30);
    System.out.println(u.getAge());

  }
}
