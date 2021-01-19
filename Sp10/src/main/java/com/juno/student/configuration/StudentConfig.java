package com.juno.student.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.juno.student.dao.StudentDao;
import com.juno.student.dto.DataBaseConnectionInfo;
import com.juno.student.service.StudentAllSelectService;
import com.juno.student.service.StudentModifyService;
import com.juno.student.service.StudentRegisterService;
import com.juno.student.service.StudentSelectService;

// 빈을 모아놓는 클래스의 의미
@Configuration
public class StudentConfig {
	
	// 해당 클래스의 new 인스턴스를 생성하고 리턴해주는 메서드들을 만들어서 스프링컨테이너 형태의 운영을 합니다.
	
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
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService (studentDao());
	}
	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService (studentDao());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService (studentDao());
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService (studentDao());
	}
}
