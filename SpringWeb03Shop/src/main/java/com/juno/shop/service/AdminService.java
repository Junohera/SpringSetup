package com.juno.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.shop.dao.AdminDao;
import com.juno.shop.dto.Member;
import com.juno.shop.dto.Order;
import com.juno.shop.dto.Paging;
import com.juno.shop.dto.Product;
import com.juno.shop.dto.Qna;

@Service
public class AdminService {
	
	@Autowired
	AdminDao ad;

	public int workerCheck(String workId, String workPwd) {
		return ad.workerCheck(workId, workPwd);
	}

	public int selectTotalCnt(String tableName, String searchType, String searchWord) {
		return ad.selectTotalCnt(tableName, searchType, searchWord);
	}

	public ArrayList<Product> selectProduct(Paging paging, String searchType, String key) {
		return ad.selectProduct(paging, searchType, key);
	}

	public ArrayList<Order> selectOrder(Paging paging, String searchType, String key) {
		return ad.selectOrder(paging, searchType, key);
	}

	public ArrayList<Member> selectMember(Paging paging, String searchType, String key) {
		return ad.selectMember(paging, searchType, key);
	}

	public ArrayList<Qna> selectQna(Paging paging, String searchType, String key) {
		return ad.selectQna(paging, searchType, key);
	}

}
