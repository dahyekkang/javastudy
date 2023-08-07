package ex04_text_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainWrapper {

  public static void ex01() {
    
    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    
    File dir = new File("D:/storage");
    File file = new File(dir, "alphabet.txt");
    
    FileOutputStream fout = null;
    
    try {
      
      fout = new FileOutputStream(file);
      
      byte[] alp = new byte[26];
      for(int i = 0; i < 26; i++) {
        alp[i] = (byte)(i+65);
        fout.write((char)alp[i]);
      }
      
    } catch(IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if(fout != null) {
            fout.close();
          }
        } catch(IOException e) {
          e.printStackTrace();
        }
      }
    }
  
  public static void ex02() {
    
    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
    File dir = new File("D:/storage");
    File src = new File(dir, "alphabet.txt");
    
    File cp = new File(dir, "alphabet2.txt");
    
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    
    try {
      
      bin = new BufferedInputStream(new FileInputStream(src));
      
      bout = new BufferedOutputStream(new FileOutputStream(cp));
      
      int readByte = 0;
      
      byte[] b = new byte[1024];
      
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      }
      
      System.out.println(src.getParent() + " 폴더의 " + src + "파일의 내용이 " + cp + "파일로 복사되었습니다.");
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) {
          bout.close();
        }
        if(bin != null) {
          bin.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    ex01();
    ex02();
  }

}