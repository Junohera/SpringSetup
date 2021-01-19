package com.juno.student.service;

import java.util.ArrayList;

import com.juno.student.dao.StudentDAO;
import com.juno.student.dto.Student;

public class StudentAllSelectService {
	private StudentDAO sdao;
	
	public StudentAllSelectService(StudentDAO sdao) {
		this.sdao = sdao;
	}
	
	public ArrayList<Student> allSelect() {
		ArrayList<Student> list = sdao.selectAll();
		return list;
	}
}