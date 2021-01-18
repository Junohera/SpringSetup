package com.juno.member.main;

import java.util.ArrayList;

import com.juno.member.dao.StudentAssembler;
import com.juno.member.dto.Student;
import com.juno.member.service.StudentAllSelectService;
import com.juno.member.service.StudentModifyService;
import com.juno.member.service.StudentRegisterService;
import com.juno.member.service.StudentSelectService;

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
		
		/*
		StudentRegisterService rs = new StudentRegisterService();
		*/
		
		/*
		Student s = new Student(
			sNum[0],
			sId[0],
			sPw[0],
			sName[0],
			sAge[0],
			sGender[0],
			sMajor[0]
		);
		*/
		/*
		StudentRegisterService rs = new StudentRegisterService(new StudentDAO());
		rs.register(s);
		*/
		
		StudentAssembler assembler = new StudentAssembler();
		StudentRegisterService rs = assembler.getRs();
		for (int i = 0; i < sNum.length; i++) {
			Student s = new Student(
				sNum[i],
				sId[i],
				sPw[i],
				sName[i],
				sAge[i],
				sGender[i],
				sMajor[i]
			);
			// rs.register(s);
		}
		
		// 저장된 데이터를 모두 읽어와서 화면에 출력
		StudentAllSelectService sa = assembler.getSa();
		ArrayList<Student> list = sa.allSelect();
		
		for (int j = 0; j < list.size(); j++) {
			print(list.get(j));
		}

		StudentModifyService sm = assembler.getSm();
		Student uStd = new Student("H49alskjdfklskl0", "userid", "12345", "agatha", 25, "W", "Korean Language");
		sm.update(uStd);
		
		StudentSelectService ss = assembler.getSs();
		String findsNum = "H49alskjdfklskl0";
		Student mStd = ss.select(findsNum);
		print(mStd);
		
		
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
