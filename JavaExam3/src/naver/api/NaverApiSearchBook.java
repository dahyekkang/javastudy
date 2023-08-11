package naver.api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class NaverApiSearchBook {
  
  private static final String CLIENT_ID = "Y3_YnXvT1PIn8b0oRnG9";
  private static final String CLIENT_SECRET = "dNU2sXe73m";
  
  private void generateImage(String spec) {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    
    
    try {
      
      // 파라미터 String spec에는 다운로드 받을 이미지 파일의 URL이 전달된다.
      // 해당 URL의 이미지 파일을 다운로드 받는다.
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != 200) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      bin = new BufferedInputStream(con.getInputStream());
      
      File dir = new File("C:/download");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      String imgName = spec.substring(spec.lastIndexOf("/"));
      
      File file = new File(dir, imgName);
      
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];
      int readByte = 0;
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      }
      
      System.out.println(file.getPath() + " 파일 다운로드 완료");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public void getSearchList() {
    
    Scanner sc = new Scanner(System.in);
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
      // 책 검색 OpenAPI를 사용해서 응답 결과 중 이미지(image) 결과만 추출하여
      // generateImage 메소드에 전달한다.
      // 10번의 generateImage 메소드 호출이 필요하다.
      
      System.out.print("책 관련 검색어를 입력하세요 >>> ");
      String query = sc.next();
      query = URLEncoder.encode(query, "UTF-8");
      String spec = "https://openapi.naver.com/v1/search/book.json?query=" + query;
      sc.close();
      
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      // 요청 메소드
      con.setRequestMethod("GET");
      
      // 요청 헤더
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != 200) {
        throw new RuntimeException(responseCode + "발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
      
      // String -> JSONObject 변환
      JSONObject obj = new JSONObject(sb.toString());
      JSONArray items = obj.getJSONArray("items");
      for(int i = 0, length = items.length(); i < length; i ++) {
        JSONObject item = items.getJSONObject(i);
        String image = item.getString("image");
        generateImage(image);
      }
      
    } catch (Exception e) {
      
      // 예외 발생 시 로그파일을 만든다.
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter drf = DateTimeFormatter.ofPattern("yyyy-MM-dd a h:mm:ss");
      String time = drf.format(now);
      
      // 예외메시지
      String message = e.getMessage();
      
      File dir = new File("C:/download/log");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, "log.txt");
      
      // try-catch-resources
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
        
        bw.write(time + ", " + message);
        bw.newLine();
        
        // 결과 메시지
        System.out.println(file.getPath() + " 파일에 로그가 작성되었습니다.");
        
      } catch(IOException e2) {
        e2.printStackTrace();
      }
      
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
}