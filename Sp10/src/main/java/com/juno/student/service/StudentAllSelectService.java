package com.juno.student.service;

import java.util.ArrayList;

import com.juno.student.dao.StudentDao;
import com.juno.student.dto.Student;

public class StudentAllSelectService {
	private StudentDao sdao;
	
	public StudentAllSelectService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public ArrayList<Student> allSelect() {
		ArrayList<Student> list = sdao.selectAll();
		return list;
	}
}