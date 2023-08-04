package ex01_web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainWrapper {

  public static void ex01() {
    
    // %ED%8F%AD%EC%97%B : 인코딩된 데이터 ( = 폭염)
    
    /*
     * URL
     * 1. Uniform Resource Location
     * 2. 정형화된 자원의 경로 표기방법(웹 주소를 의미한다.)
     * 3. 형식
     * 
     *    프로토콜://     호스트     :포트/ URLMapping ?파라미터=값&파라미터=값&파라미터=값...
     *       https://search.naver.com:8080/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=폭염
     *       
     *     1) 프로토골   : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
     *     2) 호스트     : 서버주소(돈주고 사는 거), 컴퓨터 주소
     *     3) URLMapping : 서버경로(직접 만드는 주소)
     *     4) 파라미터   : 서버로 보내는 데이터
     */
    
    /*
     * java.net.URL 클래스
     * 1. URL을 관리하는 클래스이다.
     * 2. URL을 분석하여 원하는 정보를 얻어낼 수 있다.
     * 3. URL에 접속할 수 있는 URLConnection을 생성할 수 있다.
     */
    
    // URL 정보 분석하기
    String apiURL = "https://search.naver.com:8080/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=폭염";
    
    // URL 객체 선언
    URL url = null;
    
    try {
      
      // URL 객체 생성
      url = new URL(apiURL);    // MalformedURLException 발생
      
      // URL 분석
      System.out.println("프로토콜 : " + url.getProtocol());
      System.out.println("호스트 : " + url.getHost());
      System.out.println("포트번호: " + url.getPort());
      System.out.println("파라미터 : " + url.getQuery());
      
    } catch(MalformedURLException e) {
      System.out.println("apiURL 형식 오류");
    }
  }
  
  public static void ex02() {
    
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
  
  public static void ex03() {
    
    // 웹 상의 파일 읽기
    
    // 접속할 주소(이미지 주소)
    String spec = "https://ssl.pstatic.net/melona/libs/1456/1456783/bd50949ba2627b863729_20230803153939215.jpg";
    
    // URL 객체 선언
    URL url = null;
    
    //HttpURLConnection 객체 선언
    HttpURLConnection con = null;
    
    // 입력스트림 선언 (네이버 배너를 읽는 스트림)
    BufferedInputStream bin = null;
    
    // 출력스트림 선언 (D:/storage/banner.jpeg 파일을 만드는 스트림)
    BufferedOutputStream bout = null;
    
    
    try {
      
      // URL 객체 생성
      url = new URL(spec);
      
      // HttpURLConnection 객체 생성
      con = (HttpURLConnection)url.openConnection();
      
      
      // 입력스트림 생성
      bin = new BufferedInputStream(con.getInputStream());
      
      // 출력할 파일 File 객체
      File dir = new File("D:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      
      String contentType = con.getContentType();
      String extName = contentType.substring(contentType.indexOf("/") + 1);
      String fileName = "banner." + extName;
      File file = new File(dir, fileName);
      
      
      // 출력스트림 생성
      bout = new BufferedOutputStream(new FileOutputStream(file));      
      
      // 읽은 데이터를 저장할 바이트 배열
      byte[] b = new byte[1024];      // 1Kb씩 읽기
      
      // 실제로 읽은 바이트 수
      int readByte = 0;
      
      // 읽기 (네이버 배너 이미지를 byte[] b에 저장하기
      // 쓰기 (byte[] b의 내용을 banner.jpeg 파일로 보내기)
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      }

      // 확인 메시지
      System.out.println(fileName + " 파일 생성 완료(다운로드 완료)");
      
    } catch(MalformedURLException e) {
      System.out.println("URL 주소 오류");
    } catch(IOException e) {
      System.out.println("URL 접속 오류 or 입력스트림 생성 오류");
    } finally {
      try {
        // 생성의 역순으로 닫기
        // 생성 con -> bin
        // 닫기 bin -> con
        if(bout != null) { bout.close(); }
        if(bin != null) { bin.close(); }
        if(con != null) { con.disconnect(); }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public static void ex04() {
    
    
    
  }
  
  public static void main(String[] args) {
    
    ex03();

  }

}
