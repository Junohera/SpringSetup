package com.juno.student.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.juno.student.dto.Student;
import com.juno.student.service.StudentModifyService;
import com.juno.student.service.StudentSelectService;

public class MainCalssUseImport {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtxImport.xml");
		
		StudentModifyService mds = ctx.getBean("modifyService", StudentModifyService.class);
		mds.update(new Student("H49alskjdfklskl3", "user", "12345", "agatha", 25, "W", "korean"));
		StudentSelectService sss = ctx.getBean("selectService", StudentSelectService.class);
		sss.select("H49alskjdfklskl3");
		
	}
}
