package com.juno.student.service;

import com.juno.student.dao.StudentDAO;
import com.juno.student.dto.Student;

public class StudentModifyService {
	private StudentDAO sdao;
	
	public StudentModifyService(StudentDAO sdao) {
		this.sdao = sdao;
	}
	
	public void update(Student s) {
		sdao.update(s);
	}
}
