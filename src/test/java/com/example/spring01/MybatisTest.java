package com.example.spring01;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MybatisTest {
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	// 의존관계 주입
	@Inject
	private SqlSessionFactory sqlFactory;
	@Test
	public void testFactory(){
		System.out.println(sqlFactory);
	}
	@Test
	public void testSession() throws Exception {
		try (SqlSession session = sqlFactory.openSession()) {
			System.out.println(session+"세션 확인");
			logger.info("세션 확인",session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
