package com.juno.student.main;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.juno.student.configuration.StudentConfigImport;
import com.juno.student.dto.Student;
import com.juno.student.service.StudentAllSelectService;

public class MainClassUseConfigurationsImport {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfigImport.class);
				
		StudentAllSelectService ass = ctx.getBean("allSelectService", StudentAllSelectService.class);
		
		ArrayList<Student> list = ass.allSelect();
		
		for (int j = 0; j < list.size(); j++) {
			print(list.get(j));
		}
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