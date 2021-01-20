package com.juno.student.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.juno.student.dto.EMSInformationService;
import com.juno.student.dto.Student;
import com.juno.student.service.StudentModifyService;
import com.juno.student.service.StudentSelectService;

public class MainClass {

	public static void main(String[] args) {
		String[] sNum = {
				"H49alskjdfklskl1",
				"H49alskjdfklskl2",
				"H49alskjdfklskl3",
				"H49alskjdfklskl4",
				"H49alskjdfklskl5",
				"H49alskjdfklskl6",
				"H49alskjdfklskl7",
				"H49alskjdfklskl8",
				"H49alskjdfklskl9",
				"H49alskjdfklskl0"
			};
			String[] sId = {
				"juno1",
				"juno2",
				"juno3",
				"juno4",
				"juno5",
				"juno6",
				"juno7",
				"juno8",
				"juno9",
				"juno0"
			};
			String[] sPw = {
				"1234","1234","1234","1234","1234","1234","1234","1234","1234","1234"
			};
			String[] sName = {
					"name1",
					"name2",
					"name3",
					"name4",
					"name5",
					"name6",
					"name7",
					"name8",
					"name9",
					"name0"
			};
			int[] sAge = {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
			};
			String[] sGender = {
				"M","M","M","M","M","M","M","M","M","M"
			};
			String[] sMajor = {
				"English","English","English","English","English","English","English","English","English","English"
			};
			
			String[] appCtxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"};
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtxs);
			
			StudentModifyService mds = ctx.getBean("modifyService", StudentModifyService.class);
			mds.update(new Student("H49alskjdfklskl3", "user", "12345", "agatha", 25, "W", "korean"));
			
			StudentSelectService sss = ctx.getBean("selectService", StudentSelectService.class);
			sss.select("H49alskjdfklskl3");
			EMSInformationService eis = ctx.getBean("informationService", EMSInformationService.class);
			eis.outputEMSInformation();
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
