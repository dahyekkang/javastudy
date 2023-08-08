package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class NaverCaptcha {
  
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
        sb.append(line + "\n");
      }
      
      System.out.println(sb.toString());
      
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
  
  private static void getImage() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    
    try {
      String key = getKey();    
      String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin" + key;
      
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
      System.out.println(file.getPath() + " 파일 생성 완료");
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
  }
  
  public static void main(String[] args) {
    
    String key = getKey();
    System.out.println("캡차키 : " + key);
    getImage();
  }

}
