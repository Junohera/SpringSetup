package com.juno.student.service;

import com.juno.student.dao.StudentDAO;
import com.juno.student.dto.Student;

public class StudentSelectService {
private StudentDAO sdao;
	
	public StudentSelectService(StudentDAO sdao) {
		this.sdao = sdao;
	}
	
	public Student select(String sNum) {
		return sdao.select(sNum);
	}
}
