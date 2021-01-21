package com.juno.spboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.spboard.dao.MemberDao;
import com.juno.spboard.dto.SpMember;

@Service
public class MemberService {
	
	@Autowired
	MemberDao mDao;

	public SpMember getMember(String id) {
		return mDao.getMember(id);
	}

	public int confirmId(String id) {
		return mDao.confirmId(id);
	}

	public void memberRegister(SpMember m) {
		mDao.memberRegister(m);
	}

	public int memberModify(SpMember m) {
		return mDao.memberUpdate(m);
	}

}
