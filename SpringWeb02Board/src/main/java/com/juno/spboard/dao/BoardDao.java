package com.juno.spboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.juno.spboard.dto.Paging;
import com.juno.spboard.dto.Reply;
import com.juno.spboard.dto.SpBoard;
import com.juno.spboard.util.DBManager;

@Repository
public class BoardDao {
	
	@Autowired
	DBManager d;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int selectBoardAllCount() {
		int result = 0;
		
		String sql = "SELECT COUNT(*) AS TOTALCOUNT FROM BOARD";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
		
		return result;
	}
	
	public ArrayList<SpBoard> selectBoardAll(Paging paging) {
		ArrayList<SpBoard> list = new ArrayList<SpBoard>();
		
		String sql = ""
				+ " SELECT * FROM ("
				+ " SELECT * FROM ("
				+ " SELECT ROWNUM AS RN, T.* FROM"
				+ " (SELECT * FROM BOARD ORDER BY NUM DESC) T"
				+ " ) WHERE RN >= ?"
				+ " ) WHERE RN <= ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, paging.getStartNum());
			ps.setInt(2, paging.getEndNum());
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

				String sql2 = "SELECT COUNT(*) AS CNT FROM REPLY WHERE BOARDNUM = ?";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, b.getNum());
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					b.setReplyCnt(rs2.getInt("cnt"));
				} else {
					b.setReplyCnt(0);
				}

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

	public void insertBoard(SpBoard b) {
		String sql = ""
				+ " INSERT INTO BOARD"
				+ " (NUM, PASS, USERID, EMAIL, TITLE, CONTENT) VALUES"
				+ " (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getPass());
			ps.setString(2, b.getUserid());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getTitle());
			ps.setString(5, b.getContent());
			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
	}

	public void updateBoard(SpBoard b) {
		String sql = ""
				+ " UPDATE BOARD SET "
				+ " PASS = ?, USERID = ?, EMAIL = ?, TITLE = ?, CONTENT = ? "
				+ " WHERE NUM = ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getPass());
			ps.setString(2, b.getUserid());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getTitle());
			ps.setString(5, b.getContent());
			ps.setInt(6, b.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
	}

	public void deleteBoard(int num) {
		String sql = ""
				+ " DELETE FROM BOARD "
				+ " WHERE NUM = ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
	}

	public ArrayList<Reply> selectReply(int num) {
		ArrayList<Reply> list = new ArrayList<Reply>();
		String sql = ""
				+ " SELECT * FROM REPLY WHERE BOARDNUM = ? ORDER BY NUM DESC";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reply r = new Reply();
				r.setNum(rs.getInt("num"));
				r.setBoardnum(rs.getInt("boardnum"));
				r.setUserid(rs.getString("userId"));
				r.setContent(rs.getString("content"));
				r.setWritedate(rs.getTimestamp("writedate"));
				list.add(r);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
		
		return list;
	}

	public void deleteReply(int num) {
		String sql = ""
				+ " DELETE FROM REPLY "
				+ " WHERE NUM = ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
	}

	public void addReply(Reply r) {
		String sql = ""
				+ " INSERT INTO REPLY (NUM, BOARDNUM, USERID, CONTENT) VALUES"
				+ " (REPLY_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, r.getBoardnum());
			ps.setString(2, r.getUserid());
			ps.setString(3, r.getContent());

			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
	}
}
