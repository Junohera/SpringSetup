package com.juno.member.service;

import com.juno.member.dao.StudentDAO;
import com.juno.member.dto.Student;

public class StudentSelectService {
private StudentDAO sdao;
	
	public StudentSelectService(StudentDAO sdao) {
		this.sdao = sdao;
	}
	
	public Student select(String sNum) {
		return sdao.select(sNum);
	}
}
