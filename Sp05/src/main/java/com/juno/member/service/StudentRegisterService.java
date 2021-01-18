package com.juno.member.service;

import com.juno.member.dao.StudentDAO;
import com.juno.member.dto.Student;

public class StudentRegisterService {
	private StudentDAO studentDao;

	public StudentRegisterService(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public void register(Student s) {studentDao.insert(s);}

}
