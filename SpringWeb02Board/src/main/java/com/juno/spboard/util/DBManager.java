package com.juno.spboard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DBManager {
	
	@Autowired
	DatabaseUserInfo d;
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(d.getDriver());
			con = DriverManager.getConnection(d.getUrl(), d.getId(), d.getPw());
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
}
