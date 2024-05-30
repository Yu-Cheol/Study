package net.daum;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class OracleConTest {

	private static final String DRIVER="oracle.jdbc.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER="freeday";
	private static final String PASSWORD="56789";
	
	@Test //JUnit 연습 테스트 애노테이션
	public void testCon() throws Exception{
		Class.forName(DRIVER);//jdbc드라이버 클래스 로드
		
		try(Connection con=
				DriverManager.getConnection(URL, USER, PASSWORD)){
			/* 자바 7버전에서 추가된 AutoCloseable 인터페이스를 구현상속 받은 자손은
			 * try()내에서 객체를 생성하면 finally문에서 명시적으로 close() 하지 않아도
			 * 자동으로 닫힌다.
			 */
	        System.out.println(con);		
		}catch(Exception e) {e.printStackTrace();}
	}	
}





