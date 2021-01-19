package com.juno.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.juno.word.dao.WordDao;
import com.juno.word.dto.WordSet;

public class WordSearchService {
	
	@Autowired
	private WordDao wdao;
	
	public WordSet search(String k) {
		return wdao.search(k);
	}
}
