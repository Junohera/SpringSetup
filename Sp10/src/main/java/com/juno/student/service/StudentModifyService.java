package com.juno.student.service;

import com.juno.student.dao.StudentDao;
import com.juno.student.dto.Student;

public class StudentModifyService {
	private StudentDao sdao;
	
	public StudentModifyService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void update(Student s) {
		sdao.update(s);
	}
}
