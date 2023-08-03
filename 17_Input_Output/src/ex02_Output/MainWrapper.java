package ex02_Output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainWrapper {

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
      // 스트링을 바이트배열로 바꿔주는 메소드가 3개 존재한다. getBytes.
      // 3가지 방식이 있는데 파라미터 없는 건 인코딩할 필요가 없는 것
      // 2, 3은 charset을 전달하게 되어있으므로 인코딩이 필요한 것
      // 인코딩이라는 말을 들으면 떠오르는 거 있어? UTF-8! 우리가 사용하고 있는 문자 CHARACTER SET임
      // 지정할 필요가 있으면 파라미터가 있는 생성자를 사용해라!
      // UTF-8쓰는 이유가 한글때문인데 pple은 영어이므로! 파라미터 없는 생성자 사용!
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
  
  public static void main(String[] args) {
    
    ex02();

  }

}
