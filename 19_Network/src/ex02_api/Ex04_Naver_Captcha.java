package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Ex04_Naver_Captcha {
  
  private static final String CLIENT_ID = "Y3_YnXvT1PIn8b0oRnG9";
  private static final String CLIENT_SECRET = "dNU2sXe73m";
  
  private static String getKey() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    String result = null;
    
    try {
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=0";
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      con.setRequestMethod("GET");
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      JSONObject obj = new JSONObject(sb.toString());
      result = obj.getString("key");
      
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
    return result;
    
  }
  
  private static String getImage() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    String key = null;
    
    try {
      key = getKey();    
      String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();    // 주소가 달라져서 당연히 또 해야함
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      bin = new BufferedInputStream(con.getInputStream());
      
      File dir = new File("D:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      
      File file = new File(dir, System.currentTimeMillis() + ".jpg");
      // 이름을 1개로 지정하면 이미지가 계속 덮어쓰기 되면서 이전 이미지가 사라지기 때문에 중복되지 않는 값을 파일명으로 한다.(UUID or TimeStamp값 이용)
      
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];
      int readByte = 0;
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
    return key;
    
  }
  
  private static void validInput() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    
    try {
      
      String key = getImage();
      
      Scanner sc = new Scanner(System.in);
      System.out.print("입력 >> ");
      String value = sc.next();
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value;
      sc.close();
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != 200) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      JSONObject obj = new JSONObject(sb.toString());
      System.out.println("응답시간 : " + obj.getDouble("responseTime"));
      if(obj.getBoolean("result")) {
        System.out.println("올바른 값입니다.");
      } else {
        System.out.println("올바른 값이 아닙니다.");
      }
      
      sc.close();
      
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    validInput();
  }

}
