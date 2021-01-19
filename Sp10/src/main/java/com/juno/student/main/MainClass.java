package com.juno.student.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.juno.student.configuration.StudentConfig;
import com.juno.student.dto.Student;
import com.juno.student.service.StudentModifyService;
import com.juno.student.service.StudentSelectService;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
		
		StudentModifyService mds = ctx.getBean("modifyService", StudentModifyService.class);
		mds.update(new Student("H49alskjdfklskl3", "user", "12345", "agatha", 25, "W", "korean"));
		
		StudentSelectService sss = ctx.getBean("selectService", StudentSelectService.class);
		Student s = sss.select("H49alskjdfklskl3");
		print(s);
		ctx.close();
	}
	
	public static void print(Student s) {
		System.out.print("| sNum : " + s.getsNum() + "\t");
		System.out.print("| sId : " + s.getsId() + "\t");
		System.out.print("| sPw : " + s.getsPw() + "\t");
		System.out.print("| sName : " + s.getsName() + "\t");
		System.out.print("| sAge : " + s.getsAge() + "\t");
		System.out.print("| sGender : " + s.getsGender() + "\t");
		System.out.print("| sMajor : " + s.getsMajor() + "\n");
	}

}
