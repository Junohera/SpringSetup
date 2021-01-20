package com.juno.word.service;

public class WordSearchService {
	private WordDao wdao;
	
	public WordSearchService(WordDao wdao) {
		this.wdao = wdao;
	}
	
	public WordSet search(String kw) {
		return wdao.search(kw);
	}
}
