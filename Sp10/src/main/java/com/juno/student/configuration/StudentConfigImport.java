package com.juno.student.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.juno.student.dao.StudentDao;
import com.juno.student.dto.DataBaseConnectionInfo;

@Configuration
@Import({StudentConfig02.class, StudentConfig03.class})
public class StudentConfigImport {
	
	@Bean
	public DataBaseConnectionInfo dbConnectionInfo() {
		// DataBaseConnectionInfo 형태의 객체인스턴스를 리턴해주는 메서드
		DataBaseConnectionInfo temp = new DataBaseConnectionInfo();
		temp.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		temp.setUserId("juno");
		temp.setUserPw("juno");
		temp.setDriver("oracle.jdbc.driver.OracleDriver");
		return temp;
	}
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao(dbConnectionInfo());
	}
}
