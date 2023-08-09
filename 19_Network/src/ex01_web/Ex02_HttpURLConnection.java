package ex01_web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex02_HttpURLConnection {

  public static void main(String[] args) {
    
    // 접속할 주소
    String spec = "https://ssl.pstatic.net/melona/libs/1460/1460810/617b2b029d6158784ed5_20230731133426705.png";
    
    // URL 객체 선언
    URL url = null;
    
    // HttpURLConnection 객체 선언
    HttpURLConnection con = null;
    
    try {
      
      // URL 객체 생성 (MalformedURLException 발생)
      url = new URL(spec);
      
      // HttpURLConnection 객체 생성 (IOException 발생)
      con = (HttpURLConnection)url.openConnection();
            
      /*
       * HTTP 응답코드
       * 1. 200 : 정상
       * 2. 4XX : 잘못된 요청 (클라이언트의 잘못된 요청)
       * 3. 5XX : 서버 오류 (잘못된 개발)
       */
      
      // 접속 여부 확인
      int responseCode = con.getResponseCode();
      System.out.println("접속여부 : " + (responseCode == HttpURLConnection.HTTP_OK));  // 200 == 200
      
      // 요청 헤더(User-Agent) : 무엇으로 접속했는가? ex) 자바, 브라우저(크롬, 엣지), ...)
      String userAgent = con.getRequestProperty("User-Agent");
      System.out.println("User-Agent : " + userAgent);
      
      // 요청 헤더(Referer) : 이전 주소가 무엇인가? 지금 학원페이지에 접속할건데 그 이전에 접속한 주소가 뭐냐? 지금은 null값 나올 것임
      String referer = con.getRequestProperty("Referer");
      System.out.println("Referer : " + referer);
      
      // 컨텐트 타입(Content-Type) : 어떤 타입인가?
      String contentType = con.getContentType();
      System.out.println("Content-Type : " + contentType);
      
      // 컨텐트 크기 : 크기가 얼마인가?
      int contentLength = con.getContentLength();
      System.out.println("Content-Length : " + contentLength);
      
      /*
       * 요청 메소드
       * 1. GET   : 주소(URL)를 이용한 데이터 전송 방식
       * 2. POST  : 본문(Body)을 이용한 데이터 전송 방식
       */
      
      // 요청 메소드 : 어떤 방식으로 요청했는가?
      String requestMehod = con.getRequestMethod();
      System.out.println("RequestMethod : " + requestMehod);
      
      // 접속 해제(생략 가능)
      con.disconnect();
      
    } catch(MalformedURLException e) {
      System.out.println("접속 주소 오류");
    } catch(IOException e) {
      System.out.println("접속 오류");
    }
    
  }
  
}
