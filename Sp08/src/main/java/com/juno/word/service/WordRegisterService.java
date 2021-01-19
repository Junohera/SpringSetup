package com.juno.word.service;

import com.juno.word.dao.WordDao;
import com.juno.word.dto.WordSet;

public class WordRegisterService {
	private WordDao wdao = null;
	
	WordRegisterService(WordDao dao) {
		this.wdao = dao;
	}
	public void register(WordSet ws) {
		wdao.insert(ws);
	}
}
