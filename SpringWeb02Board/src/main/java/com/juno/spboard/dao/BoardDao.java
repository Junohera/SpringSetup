package com.juno.spboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.juno.spboard.dto.SpBoard;
import com.juno.spboard.util.DBManager;

@Repository
public class BoardDao {
	
	@Autowired
	DBManager d;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<SpBoard> selectBoardAll() {
		ArrayList<SpBoard> list = new ArrayList<SpBoard>();
		
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SpBoard b = new SpBoard();
				b.setNum(rs.getInt("num"));
				b.setPass(rs.getString("pass"));
				b.setUserid(rs.getString("userid"));
				b.setEmail(rs.getString("email"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setReadcount(rs.getInt("readcount"));
				b.setWritedate(rs.getTimestamp("writedate"));
				list.add(b);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
		
		return list;
	}

	public SpBoard selectBoard(int num) {
		SpBoard b = null;
		
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				b = new SpBoard();
				b.setNum(rs.getInt("num"));
				b.setPass(rs.getString("pass"));
				b.setUserid(rs.getString("userid"));
				b.setEmail(rs.getString("email"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setReadcount(rs.getInt("readcount"));
				b.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
		
		return b;
	}

	public void increaseReadCount(int num) {
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
	}
}
