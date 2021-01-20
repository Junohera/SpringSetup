package com.juno.student.service;

import com.juno.student.dao.StudentDAO;
import com.juno.student.dto.Student;

public class StudentRegisterService {
	private StudentDAO studentDao;

	public StudentRegisterService(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public void register(Student s) {studentDao.insert(s);}

}
