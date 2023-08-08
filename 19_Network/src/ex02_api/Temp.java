package ex02_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Temp {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    String query = null;
    System.out.println("검색어 입력하세요 >>> ");
    query = sc.nextLine();
    try {
      query = URLEncoder.encode(query, "UTF-8");      
    } catch(UnsupportedEncodingException e) {
      System.out.println("검색어 인코딩 실패");
    }
    
    String spec = "https://openapi.naver.com/v1/search/blog.json?query=" + query;
    
    String clientId = "Y3_YnXvT1PIn8b0oRnG9";
    String clientSecret = "dNU2sXe73m";
    Map<String, String> requestHeaders = new HashMap<String, String>();
    requestHeaders.put("X-Naver-Client-Id", clientId);
    requestHeaders.put("X-Naver-Client-Secret", clientSecret);
    
    String result = get(spec, requestHeaders);
    System.out.println(result);
    
  }
  
  private static String get(String spec, Map<String, String> requestHeaders) {
    HttpURLConnection con = connect(spec);
    String result = null;
    
    try {
      con.setRequestMethod("GET");
      
      for(Entry<String, String> entry : requestHeaders.entrySet()) {
        con.setRequestProperty(entry.getKey(), entry.getValue());
      }
      
      int responseCode = con.getResponseCode();
      if(responseCode == HttpURLConnection.HTTP_OK) {
        result = readBody(con.getInputStream());
      } else {
        result = readBody(con.getErrorStream());
      }
      
    } catch(IOException e) {
      System.out.println("요청 또는 응답 실패");
    } finally {
      con.disconnect();   // reader나 writer와 달리 try문이 꼭 필요하지는 않음!
    }
    return result;
  }
  
  private static HttpURLConnection connect(String spec) {
    URL url = null;
    HttpURLConnection con = null;
    try {
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
    } catch(MalformedURLException e) {
      System.out.println("주소가 잘못되었다.");
    } catch(IOException e) {
      System.out.println("접속이 안 된다.");
    }
    return con;
  }
  
  private static String readBody(InputStream in) {
    
    String result = null;
    
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
      
      result = sb.toString();
      
    } catch(IOException e) {
      System.out.println("응답 실패");
    }
    
    return result;
    
  }

}
