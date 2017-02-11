package com.example.spring01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	// Logger logger = LoggerFactory.getLogger(log를 수집할 대상 클래스.class);
	// private : 외부에서 로그를 가로채지 못하도록 하기 위해서
	// static final : 로그 내용이 바뀌지 않으므로
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class); // log를 수집할 대상 클래스
	// jdbc 오라클 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	// oracle 연결 문자열
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	// 사용자 아이디
	private static final String USER = "spring";
	private static final String PW = "1234";
	
	// 테스트 JUnit
	@Test
	public void testConnecttion() throws Exception {
		Class.forName(DRIVER);
		try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(conn);
			System.out.println("DB에 연결되었습니다.");
			// 로그르를 수집할 method에서 로그 수집 명령어 호출
			// logger.info("로그 타이틀", 출력할 값)
			logger.info("DB에 연결되었습니다.", conn);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
