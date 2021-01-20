package com.juno.word.util;

public class DataBaseUserInfo {
	private String url;
	private String id;
	private String pw;
	private String driver;
	
	public DataBaseUserInfo() {}
	public DataBaseUserInfo(String url, String id, String pw, String driver) {
		super();
		this.url = url;
		this.id = id;
		this.pw = pw;
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
}
