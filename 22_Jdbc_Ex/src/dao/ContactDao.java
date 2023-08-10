package dao;

import java.awt.dnd.DropTargetAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.ContactDto;

// Contact table에 접근하기 위한 객체를 따로 만듦

/*
 * DAO
 * 1. Database Access Object
 * 2. 데이터베이스에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받는 객체이다.
 * 3. 하나의 객체만 만들어서 사용하는 Singleton Pattern으로 객체를 생성한다.
 */
public class ContactDao {
  
  /*
   * Singleton Pattern
   * 1. 오직 하나의 객체만 만들 수 있도록 처리하는 패턴이다.
   * 2. 미리 하나의 객체를 만든 뒤 해당 객체를 가져다 사용할 수 있도록 처리한다.
   * 3. 객체 생성이 불가능하도록 생성자를 호출할 수 없게 만든다.
   */
  // dao의 외부에서는 new ContactDao();를 못 하게 막는다.
  
  private static ContactDao dao = new ContactDao();
  private ContactDao() {
    // 내부에서만 호출할 수 있는 생성자
  }
  
  // 외부에서 접근할 수 있는 건 이것 뿐이다.
  // dao를 외부로 빼려면 getter를 만들어야 한다. (getDao를 호출하는 방법밖에 없음)
  public static ContactDao getDao() {
    return dao;
  }
  // 외부에서 ContactDao.getDao() 로 dao를 부를 수 있다. 이는 멤버변수가 static이기 때문이며, dao가 static이기 때문에 getDao도 static을 사용한다.
  // 클래스 변수?
  //  클래스 변수는 인스턴스 변수에 static만 붙여주면 됩니다.
  // 인스턴스 변수?
  //  인스턴스 변수는 인스턴스가 생성될 때 생성됩니다. 그렇기 때문에 인스턴스 변수의 값을 읽어오거나 저장하려면 인스턴스를 먼저 생성해야합니다. 
  // 인스턴스 별로 다른 값을 가질 수 있으므로, 각각의 인스턴스마다 고유의 값을 가져야할 때는 인스턴스 변수로 선언합니다.
  // 인스턴스 변수는 각각 고유한 값을 가지지만 클래스 변수는 모든 인스턴스가 공통된 값을 공유하게 됩니다. 
  // 한 클래스의 모든 인스턴스들이 공통적인 값을 가져야할 때 클래스 변수로 선언합니다. 
  // 클래스가 로딩될 때 생성되어(그러므로 메모리에 딱 한번만 올라갑니다.) 
  // 종료 될 때 까지 유지되는 클래스 변수는 public 을 붙이면 같은 프로그램 내에서 어디서든 접근할 수 있는 전역 변수가 됩니다. 
  // 또한 인스턴스 변수의 접근법과 다르게 인스턴스를 생성하지 않고 클래스이름.클래스변수명 을 통해서 접근할 수 있습니다.
  
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  
  private Connection getConnection() {
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");  // OracleDriver 클래스를 부른다.
      
      Properties p = new Properties();
      p.load(new BufferedReader(new FileReader("src/db.properties")));
      
      con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));  // con 만들기
      
     } catch(Exception e) {
       e.printStackTrace();
     }
    
    return con;
    
  }
  
  private void close() {
    
    try {
      if(rs != null) rs.close();
      if(ps != null) ps.close();
      if(con != null) con.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  // 모든 CRUD는 시작은 getConnection이고, 끝은 close()이다.

  /**
   * 삽입메소드<br>
   * @param contactDto 삽입할 연락처 정보(name, tel, email, address)
   * @return insertCount 삽입된 행(Row)의 개수, 1이면 삽입 성공, 0이면 삽입 실패
   */
  public int insert(ContactDto contactDto) {
    
    int insertCount = 0;
    
    try {
      
      con = getConnection();
      String sql = "INSERT INTO CONTACT_T(CONTACT_NO, NAME, TEL, EMAIL, ADDRESS, CREATED_AT) VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'))";
      ps = con.prepareStatement(sql);
      ps.setString(1, contactDto.getName());
      ps.setString(2, contactDto.getTel());
      ps.setString(3, contactDto.getEmail());
      ps.setString(4, contactDto.getAddress());
      insertCount = ps.executeUpdate();
      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return insertCount;
    
  }
  
  /**
   * 수정 메소드<br>
   * @param contactDto 수정할 연락처 정보(contact_no, name, tel, email, address)
   * @return updateCount 수정된 행(Row)의 개수, 1이면 수정 성공, 0이면 수정 실패
   */
  public int update(ContactDto contactDto) {
    
    int updateCount = 0;
    
    try {
      
      con = getConnection();
      String sql = "UPDATE CONTACT_T SET NAME = ?, TEL = ?, EMAIL = ?, ADDRESS = ? WHERE CONTACT_NO = ?";
      
      ps = con.prepareStatement(sql);
      ps.setString(1, contactDto.getName());
      ps.setString(2, contactDto.getTel());
      ps.setString(3, contactDto.getEmail());
      ps.setString(4, contactDto.getAddress());
      ps.setInt(5, contactDto.getContact_no());
      
      updateCount = ps.executeUpdate();
      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return updateCount;
  }
  
  /**
   * 삭제 메소드<br>
   * @param contact_no 삭제할 연락처 번호
   * @return deleteCount 삭제된 행(Row)의 개수, 1이면 삭제 성공, 0이면 삭제 실패
   */
  public int delete(int contact_no) {
    
    int deleteCount = 0;
    
    try {
      
      con = getConnection();
      String sql = "DELETE FROM CONTACT_T WHERE CONTACT_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, contact_no);
      deleteCount = ps.executeUpdate();

    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return deleteCount;
    
  }
  
  /**
   * 전체 조회 메소드<br>
   * @return 조회된 모든 연락처 정보(ContactDto)
   */
  public List<ContactDto> selectList(){
    
    List<ContactDto> list = new ArrayList<ContactDto>();
    
    try {
      
      con = getConnection();
      String sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS FROM CONTACT_T ORDER BY CONTACT_NO ASC";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        ContactDto contactDto = new ContactDto();
        contactDto.setContact_no(rs.getInt("CONTACT_NO"));
        contactDto.setName(rs.getString("NAME"));
        contactDto.setTel(rs.getString("TEL"));
        contactDto.setEmail(rs.getString("EMAIL"));
        contactDto.setAddress(rs.getString("ADDRESS"));
        contactDto.setCreated_at(rs.getString("CREATED_AT"));
        list.add(contactDto);
      }
      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return list;
    
  }
  
  
  
}
