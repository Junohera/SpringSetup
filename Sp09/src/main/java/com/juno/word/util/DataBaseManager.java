package com.juno.word.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

public class DataBaseManager {
	private String driver;
	private String url;
	private String id;
	private String pw;

	// applicationContext.xml의 의존주입 -> @Autowired에 의한 자동주입
	// @Autowired가 constructor-arg 역할을 대신합니다.
	@Autowired
	public DataBaseManager(DataBaseUserInfo i) {
		url = i.getUrl();
		driver = i.getDriver();
		id = i.getId();
		pw = i.getPw();
	}
	
	// Autowired를 생성자에서 사용할 경우, 기본 생성자가 필요합니다.
	public DataBaseManager() {}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();}
		
		return con;
	}
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
