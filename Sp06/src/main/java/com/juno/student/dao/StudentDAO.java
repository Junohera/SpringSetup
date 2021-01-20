package com.juno.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.student.dto.DataBaseConnectionInfo;
import com.juno.student.dto.Student;

public class StudentDAO {
	String driver = null;
	String url = null;
	String id = null;
	String pw = null;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	StudentDAO(DataBaseConnectionInfo info) {
		this.driver = info.getDriver();
		this.url = info.getJdbcUrl();
		this.id = info.getUserId();
		this.pw = info.getUserPw();
	}
	
	private Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();}
		
		return con;
	}
	private void close() {
		try {
			if (con != null) con.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void insert(Student s) {
		String sql = "INSERT INTO STUDENT (SNUM, SID, SPW, SNAME, SAGE, SGENDER, SMAJOR)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getsNum());
			ps.setString(2, s.getsId());
			ps.setString(3, s.getsPw());
			ps.setString(4, s.getsName());
			ps.setInt(5, s.getsAge());
			ps.setString(6, s.getsGender());
			ps.setString(7, s.getsMajor());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {close();}
		
	}
	
	public void update(Student s) {
		String sql = "UPDATE STUDENT" +
			" SET" +
			"	SID = ?" +
			"	, SPW = ?" +
			"	, SNAME = ?" +
			"	, SAGE = ?" +
			"	, SGENDER = ?" +
			"	, SMAJOR = ?" +
			" WHERE SNUM = ?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, s.getsId());
			ps.setString(2, s.getsPw());
			ps.setString(3, s.getsName());
			ps.setInt(4, s.getsAge());
			ps.setString(5, s.getsGender());
			ps.setString(6, s.getsMajor());
			ps.setString(7, s.getsNum());

			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {close();}
	}
	
	public ArrayList<Student> selectAll() {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Student std = new Student(
					rs.getString("sNum")
					, rs.getString("sId")
					, rs.getString("sPw")
					, rs.getString("sName")
					, rs.getInt("sAge")
					, rs.getString("sGender")
					, rs.getString("sMajor")
				);
				list.add(std);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {close();}
		return list;
	}
	
	public Student select(String sNum) {
		Student s = null;
		String sql = "SELECT * FROM STUDENT WHERE SNUM = ?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sNum);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				s = new Student(
					rs.getString("sNum")
					, rs.getString("sId")
					, rs.getString("sPw")
					, rs.getString("sName")
					, rs.getInt("sAge")
					, rs.getString("sGender")
					, rs.getString("sMajor")
				);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {close();}
		return s;
	}
	
}