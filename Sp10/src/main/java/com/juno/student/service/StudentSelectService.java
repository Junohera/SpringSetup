package com.juno.student.service;

import com.juno.student.dao.StudentDao;
import com.juno.student.dto.Student;

public class StudentSelectService {
private StudentDao sdao;
	
	public StudentSelectService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public Student select(String sNum) {
		return sdao.select(sNum);
	}
}
