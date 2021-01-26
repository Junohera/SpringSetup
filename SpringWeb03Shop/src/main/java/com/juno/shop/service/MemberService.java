package com.juno.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.shop.dao.MemberDao;
import com.juno.shop.dto.Address;
import com.juno.shop.dto.Member;

@Service
public class MemberService {

	@Autowired
	MemberDao md;

	public Member getMember(String id) {
		return md.getMember(id);
	}

	public int confirmId(String id) {
		return md.confirmId(id);
	}

	public List<Address> selectAddressByDong(String dong) {
		return md.selectAddressByDong(dong);
	}

	public void insertMember(Member m) {
		md.insertMember(m);
	}

	public void updateMember(Member m) {
		md.updateMember(m);
	}

	public Member findId(String name, String phone) {
		return md.getMember(name, phone);
	}

	public Member findId(String id, String name, String phone) {
		return md.getMember(id, name, phone);
	}

	public void resetPw(Member m) {
		md.resetPw(m);
	}

}
