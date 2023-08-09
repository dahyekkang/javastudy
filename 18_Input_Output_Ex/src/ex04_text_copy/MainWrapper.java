package ex04_text_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrapper {

  public static void ex01() {
    
    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    
    File dir = new File("D:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    File file = new File(dir, "alphabet.txt");
    
    // 버퍼출력스트림 생성(close가 필요 없는 try-catch-resources문)
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
      
      // 알파벳 순차적으로 저장
      for(char ch = 'A'; ch <= 'Z'; ch++) {
        writer.write(ch);
      }
      
      // 버퍼출력스트림에 (혹시) 남아있는 모든 데이터를 보내기
      writer.flush();    // 잘 들어가는데 마지막 Z가 들어가지 않는 경우가 있어 만약을 위해 안전하게 처리해준다.
      
      // 결과 메시지
      System.out.println(file.getPath() + " 파일 생성 완료");
      
    } catch(IOException e) {
        e.printStackTrace();
      } 
    }
  
  
  public static void ex02() {
    
    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
    
    // 디렉터리 File 객체
    File dir = new File("D:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    
    // 원본 File 객체
    File src = new File(dir, "alphabet.txt");
    
    // 복사본 File 객체
    File cp = new File(dir, "alphabet2.txt");

    // try-catch-resources
    try (BufferedReader br = new BufferedReader(new FileReader(src)); 
         BufferedWriter bw = new BufferedWriter(new FileWriter(cp))){

      // 복사단위 5 char
      char[] cbuf = new char[5];
      
      // 실제로 읽은 char 수
      int readChar = 0;
      
      // 복사
      while((readChar = br.read(cbuf)) != -1) {
        bw.write(cbuf, 0, readChar);
      }
      
      // 결과 메시지
      System.out.println(src.getParent() + " 폴더의 " + src + " 파일의 내용이 " + cp + " 파일로 복사되었습니다.");
      
    } catch(IOException e) {
      e.printStackTrace();
    } 
  }
  
  public static void main(String[] args) {
    ex01();
    ex02();
  }

}