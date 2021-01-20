package com.juno.member.service;

import com.juno.member.dao.StudentDAO;
import com.juno.member.dto.Student;

public class StudentModifyService {
	private StudentDAO sdao;
	
	public StudentModifyService(StudentDAO sdao) {
		this.sdao = sdao;
	}
	
	public void update(Student s) {
		sdao.update(s);
	}
}
