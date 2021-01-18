package com.juno.member.dao;

import com.juno.member.service.StudentAllSelectService;
import com.juno.member.service.StudentModifyService;
import com.juno.member.service.StudentRegisterService;
import com.juno.member.service.StudentSelectService;

public class StudentAssembler {
	private StudentDAO sdao;
	private StudentRegisterService rs;
	private StudentAllSelectService sa;
	private StudentModifyService sm;
	private StudentSelectService ss;
	
	public StudentAssembler() {
		sdao = new StudentDAO();
		rs = new StudentRegisterService(sdao);
		sa = new StudentAllSelectService(sdao);
		sm = new StudentModifyService(sdao);
		ss = new StudentSelectService(sdao);
		
	} // sdao 와 rs를 조립 : rs만 있다면 레코드 추가가 가능한 상태

	public StudentModifyService getSm() {
		return sm;
	}

	public void setSm(StudentModifyService sm) {
		this.sm = sm;
	}

	public StudentSelectService getSs() {
		return ss;
	}

	public void setSs(StudentSelectService ss) {
		this.ss = ss;
	}

	public StudentAllSelectService getSa() {
		return sa;
	}
	public StudentRegisterService getRs() {
		return rs;
	}
}
