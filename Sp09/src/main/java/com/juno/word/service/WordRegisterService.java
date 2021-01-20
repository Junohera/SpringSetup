package com.juno.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.juno.word.dao.WordDao;
import com.juno.word.dto.WordSet;

public class WordRegisterService {
	
	@Autowired
	private WordDao wdao;
	
	public void register(WordSet ws) {
		wdao.insert(ws);
	}
}
