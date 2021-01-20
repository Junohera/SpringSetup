package com.juno.word.service;

public class WordRegisterService {
	private WordDao wdao;
	
	public WordRegisterService(WordDao wdao) {
		this.wdao = wdao;
	}
	
	public void register(WordSet wordSet) {
		wdao.insert(wordSet);
	}
}
