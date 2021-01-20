package com.juno.student.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.juno.student.dao.StudentDao;
import com.juno.student.service.StudentAllSelectService;
import com.juno.student.service.StudentRegisterService;

@Configuration
public class StudentConfig03 {
	
	@Autowired
	StudentDao sdao;
		
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService (sdao);
	}
	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService (sdao);
	}
}
