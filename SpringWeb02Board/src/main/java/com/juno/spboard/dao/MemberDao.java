package com.juno.spboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.juno.spboard.dto.SpMember;
import com.juno.spboard.util.DBManager;

@Repository
public class MemberDao {
	
	@Autowired
	DBManager d;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public SpMember getMember(String id) {
		SpMember m = null;
		String sql = "SELECT * FROM SPMEMBER WHERE ID = ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				m = new SpMember();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setPhone1(rs.getString("phone1"));
				m.setPhone2(rs.getString("phone2"));
				m.setPhone3(rs.getString("phone3"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
		
		return m;
	}

	public int confirmId(String id) {
		int result = 0;
		String sql = "SELECT * FROM SPMEMBER WHERE ID = ?";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
		
		return result;
	}

	public void memberRegister(SpMember m) {
		String sql = "INSERT INTO SPMEMBER(ID, PW, NAME, PHONE1, PHONE2, PHONE3, EMAIL) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = d.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPw());
			ps.setString(3, m.getName());
			ps.setString(4, m.getPhone1());
			ps.setString(5, m.getPhone2());
			ps.setString(6, m.getPhone3());
			ps.setString(7, m.getEmail());
			ps.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {d.close(con, ps, rs);}
	}
}
