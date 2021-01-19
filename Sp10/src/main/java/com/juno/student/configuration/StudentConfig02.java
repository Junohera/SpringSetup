package com.juno.student.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.juno.student.dao.StudentDao;
import com.juno.student.service.StudentModifyService;
import com.juno.student.service.StudentSelectService;

@Configuration
public class StudentConfig02 {
	
	@Autowired
	StudentDao sdao;
		
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService (sdao);
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService (sdao);
	}
}
