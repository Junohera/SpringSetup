package com.juno.word.dto;

public class WordSet {
	private String wordKey;
	private String workValue;
	
	
	public WordSet(String wordKey, String workValue) {
		super();
		this.wordKey = wordKey;
		this.workValue = workValue;
	}
	public String getWordKey() {
		return wordKey;
	}
	public void setWordKey(String wordKey) {
		this.wordKey = wordKey;
	}
	public String getWorkValue() {
		return workValue;
	}
	public void setWorkValue(String workValue) {
		this.workValue = workValue;
	}
	
	
}
