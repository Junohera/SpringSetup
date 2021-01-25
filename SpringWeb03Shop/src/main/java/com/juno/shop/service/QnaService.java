package com.juno.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.shop.dao.QnaDao;
import com.juno.shop.dto.Qna;

@Service
public class QnaService {
	
	@Autowired
	QnaDao qd;

	public List<Qna> listQna(String id) {
		return qd.listQna(id);
	}

	public Qna getQna(int qseq) {
		return qd.getQna(qseq);
	}

	public void insertQna(Qna q) {
		qd.insertQna(q);
	}
}
