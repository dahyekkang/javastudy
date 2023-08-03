package ex02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

public class MainWrapper {
  
  // 출력 스트림은 덮어쓰기 방식이다.

  /*
   * java.io.OutputStream 클래스
   * 1. 바이트 기반의 출력 스트림이다. 스트림이라는건 도로라고 생각하면 좋음(출력할 때 사용하는 통로)
   * 2. 출력 단위
   *    1) int
   *    2) byte[]
   */
  
  public static void ex01() {
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex01.dat");
    
    // 파일출력스트림 선언
    FileOutputStream fout = null;
    
    try {
      
      // 파일출력스트림 생성 (반드시 예외 처리가 필요한 코드)
      fout = new FileOutputStream(file);
      
      // 출력할 데이터(파일로 보낼 데이터)
      int c = 'A';            // int
      String s = "pple";
      byte[] b = s.getBytes();    // byte[] : String을 byte[]로 변환
      // 출력(파일로 데이터 보내기)
      fout.write(c);
      fout.write(b);
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fout != null) {
          fout.close(); // 출력스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }       
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");
    // getPath: parent랑 filename 다 가져온다 파일 크지 않기 때문에 KB로 바꿀 필요 없다.
    
    // 자바가 파일을 만들어줄거고, 파일 안에 Apple이 들어갈 것이다. 텍스트의 크기를 확인할 수 있는 코드도 넣었다.
    
    // 결과 : Apple : 영어 5글자이기 때문에 5바이트가 맞다!

  }

  public static void ex02() {
    
    // C:\storage\ex02.dat 파일로 "안녕하세요" 보내기, 파일 크기 확인
    
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex02.dat");
    
    FileOutputStream fout = null;
    
    try {
      
      // 파일출력스트림 생성 (반드시 예외 처리가 필요한 코드)
      fout = new FileOutputStream(file);
      
      // 출력할 데이터(파일로 보낼 데이터)
      String s = "안녕하세요";
      byte[] b = s.getBytes("UTF-8");
      
      // 출력(파일로 데이터 보내기)
      fout.write(b);
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fout != null) {
          fout.close();   // 출력스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");
    
  }
  
  public static void ex03() {
    
    /*
     * java.io.BufferedOutputStream 클래스
     * 1. 내부 버퍼를 가지고 있는 출력스트림이다.
     * 2. 많은 데이터를 한 번에 출력하기 때문에 속도 향상을 위해서 사용한다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex03.dat");
    
    // 파일아웃풋스트림 : 한 번에 하나씩 내보내는 것
    
    // 버퍼출력스트림 선언 : 잔뜩 실어서 한 번에 내보내는 방식! 속도 향상을 위해 사용 (이름은 버퍼드 아웃풋 스트림)
    BufferedOutputStream bout = null;
    
    try {
      
      // 버퍼출력스트림 생성 (반드시 예외 처리가 필요한 코드)
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      // 출력할 데이터(파일로 보낼 데이터)
      String s1 = "안녕하세요";
      String s2 = "반갑습니다";
      int c = '\n';
      
      // 변환과 출력 한 번에 하기 (변환하여 파일로 데이터 보내기)
      bout.write(s1.getBytes("UTF-8"));
      bout.write(c);
      bout.write(s2.getBytes(StandardCharsets.UTF_8));    // getBytes("UTF-8")과 동일하다.
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) {
          bout.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + "파일 크기 : " + file.length() + "바이트");
    
  }
  
  public static void ex04() {
    
    /*
     * java.io.DataOutputStream 클래스
     * 1. int, double, String 등의 변수를 그대로 출력하는 출력스트림이다.
     * 2. 보조스트림으므로 메인스트림과 함께 사용한다.
     */
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex04.dat");
    
    // 데이터출력스트림 선언
    DataOutputStream dout = null;
    
     try {
      
      // 데이터출력스트림 생성 (반드시 예외 처리가 필요한 코드)
      dout = new DataOutputStream(new FileOutputStream(file));
      
      // 출력할 데이터(파일로 보낼 데이터)
      String name = "tom";
      int age = 50;
      double height = 180.5;
      String school = "가산대학교";
      
      // 변환과 출력 한 번에 하기 (변환하여 파일로 데이터 보내기)
      dout.writeChars(name);  // 영어여서 byte로 해도 된다.    // dout.writeChar('t'), dout.writeChar('o'), dout.writeChar('m')
      dout.writeInt(age);    // 이거 써야함 선택불가
      dout.writeDouble(height);   // 이거 써야함 선택불가
      dout.writeUTF(school);    // 한글 처리.
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(dout != null) {
          dout.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + "파일 크기 : " + file.length() + "바이트");
    // 변수값 그대로 저장했기 때문에 텍스트를 메모장에서 확인할 수 없다.(이상하게 나옴)
    
  }
  
  public static void ex05() {
    
    // 스트림에 객체가 담아지지 않아서 객체를 직렬화과정을 거치게 해야함.
    // 객체가 썰기 전의 김밥이라고 생각. 직렬화 후는 썰어놓은 김밥.
    // 객체를 통째로 보낼 수 없어서 잘게 쪼개서 보내겠다!
    // 직렬화된 객체가 보이면 스트림으로 이동시키고 싶어서 직렬화 했구나~
    
    /*
     * java.io.ObjectOutputStream 클래스
     * 1. 객체를 그대로 출력하는 출력스트림이다.
     * 2. 직렬화(Serializable)된 객체를 보낼 수 있다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
 // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex05.dat");
    
    // 객체출력스트림 선언
    ObjectOutputStream oout = null;
    
     try {
      
      // 객체출력스트림 생성 (반드시 예외 처리가 필요한 코드)
       oout = new ObjectOutputStream(new FileOutputStream(file));
      
      // 출력할 데이터(파일로 보낼 데이터)
      String name = "tom";
      int age = 50;
      double height = 180.5;
      String school = "가산대학교";
      Student student = new Student(name, age, height, school);
      
      // 변환과 출력 한 번에 하기 (변환하여 파일로 데이터 보내기)
      oout.writeObject(student);
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(oout != null) {
          oout.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + "파일 크기 : " + file.length() + "바이트");
    
  }
  
  public static void main(String[] args) {
    
    ex03();
    
  }

}
