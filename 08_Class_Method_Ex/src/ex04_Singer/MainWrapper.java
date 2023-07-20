package ex04_Singer;

public class MainWrapper {

  public static void main(String[] args) {

    Song song = new Song();
    
    song.setTitle("눈누누");
    song.setGenre("댄스");
    song.setPlayTime(3.5);
    
    song.info();    // 제목 : ㅌ, 장르 : ㅌ, 재생시간 : 3.5분
    
    Singer singer = new Singer();
    
    singer.setName("강댜혜");
    singer.setTitleSong(song);
    
    singer.info();  // 이름 : 강다혜 
                    // 제목 : 눈누누, 장르 : 댄스, 재생시간 : 3.5분
    
  }

}
