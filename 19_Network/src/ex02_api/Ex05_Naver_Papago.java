package ex02_api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Ex05_Naver_Papago {
  
  public static void main(String[] args) {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedOutputStream bout = null;   // 서버로 POST 데이터 보내는 용도
    BufferedReader reader = null;
    
    try {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("번역할 한국어 입력 >>> ");
      String text = sc.nextLine();
      
      String spec = "https://openapi.naver.com/v1/papago/n2mt";
      String clientId = "Y3_YnXvT1PIn8b0oRnG9";
      String clientSecret = "dNU2sXe73m";
      
      String params = "source=ko&target=en&text=" + text;
      // HTTP 메서드가 GET방식으로 동작하는 것이 아니라 POST 방식으로 동작하기 때문에
      // 서버 측으로 OutputStream을 써서 보낼 것임. 파라미터를 주소로 보낼 수 없으니까. 보안이 필요할 때 POST 방식 사용한다.
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      // 요청 메소드 POST (생략할 수 없다.)
      con.setRequestMethod("POST");
      
      // 요청 헤더 (clientId, clientSecret)
      con.setRequestProperty("X-Naver-Client-Id", clientId);
      con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
      
      // OutputStream을 이용해서 POST 데이터를 보내겠다.
      con.setDoOutput(true);
      
      // OutputStream을 이용해서 POST 데이터 보내기
      bout = new BufferedOutputStream(con.getOutputStream());
      // OutputStream으로 보낼 수 있는 타입은 int 아니면 byte[] 뿐이다. 아까 만들어둔 String param을 int는 불가능하고, byte[]로 바꿔주어야 함.(getBytes()이용)
      bout.write(params.getBytes());
      bout.flush();   
      // stream은 통로라고 생각하면 되는데 write가 보내는 건데. write로 보낸다고 했는데 안가고 write안에 있는거다. 그래서 후 부는 빨대의 역할을 하는 flush로 확실하게 보낸다.
      
      // 여기까지를 요청으로 본다!
      
      
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
      JSONObject message = obj.getJSONObject("message");
      JSONObject result = message.getJSONObject("result");
      String translatedText = result.getString("translatedText");
      
      System.out.println("번역 전 : " + text);
      System.out.println("번역 결과");
      System.out.println("---------");
      System.out.println(translatedText);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(bout != null) bout.close();
        if(con != null) con.disconnect();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }

}
