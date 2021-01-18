package com.juno.member.service;

import java.util.ArrayList;

import com.juno.member.dao.StudentDAO;
import com.juno.member.dto.Student;

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