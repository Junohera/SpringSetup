package com.juno.word.service;

import com.juno.word.dao.WordDao;
import com.juno.word.dto.WordSet;

public class WordSearchService {
	private WordDao wdao = null;
	
	WordSearchService(WordDao dao) {
		this.wdao = dao;
	}
	public WordSet search(String k) {
		return wdao.search(k);
	}
}
