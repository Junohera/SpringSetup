package com.juno.word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.juno.word.dto.WordSet;
import com.juno.word.util.DataBaseManager;

public class WordDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Autowired
	DataBaseManager db;
	
	public void insert(WordSet ws) {
		String sql = "INSERT INTO WORDSET (WORDKEY, WORDVALUE) VALUES (?, ?)";
		
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, ws.getWordKey());
			ps.setString(2, ws.getWorkValue());
			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {db.close(con, ps, rs);}
	}
	
	public WordSet search(String wk) {
		WordSet ws = null;
		String sql = "SELECT * FROM WORDSET WHERE WORDKEY = ?";
		
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, wk);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				ws = new WordSet(rs.getString("wordkey"), rs.getString("wordvalue"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {db.close(con, ps, rs);}
		
		return ws;
	}

}
