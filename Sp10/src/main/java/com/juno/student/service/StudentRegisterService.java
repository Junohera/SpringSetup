package com.juno.student.service;

import com.juno.student.dao.StudentDao;
import com.juno.student.dto.Student;

public class StudentRegisterService {
	private StudentDao studentDao;

	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void register(Student s) {studentDao.insert(s);}

}
