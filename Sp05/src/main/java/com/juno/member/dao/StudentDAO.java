package com.juno.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.member.dto.Student;

public class StudentDAO {
	 String driver = "oracle.jdbc.driver.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
	 String id = "juno";
	 String pw = "juno";
	 Connection con = null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;
	 
	 public ArrayList<Student> selectAll() {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
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
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
				if (ps != null) ps.close();
				if (rs != null) rs.close();
			} catch (SQLException e) { e.printStackTrace();}
		}
		return list;
	}
	 
	 public void insert(Student s) {
		String sql = "INSERT INTO STUDENT (SNUM, SID, SPW, SNAME, SAGE, SGENDER, SMAJOR)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getsNum());
			ps.setString(2, s.getsId());
			ps.setString(3, s.getsPw());
			ps.setString(4, s.getsName());
			ps.setInt(5, s.getsAge());
			ps.setString(6, s.getsGender());
			ps.setString(7, s.getsMajor());
			
			int result = ps.executeUpdate();
			System.out.println(result);
			
			if (result == 1) {
				System.out.println("저장성공");
			} else {
				System.out.println("저장 실패");
			}
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
				if (ps != null) ps.close();
			} catch (SQLException e) { e.printStackTrace();}
		}
	 }

	public Student select(String sNum) {
		Student std = null;
		String sql = "SELECT * FROM STUDENT WHERE SNUM = ?";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			ps = con.prepareStatement(sql);
			ps.setString(1, sNum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				std = new Student(
					rs.getString("sNum")
					, rs.getString("sId")
					, rs.getString("sPw")
					, rs.getString("sName")
					, rs.getInt("sAge")
					, rs.getString("sGender")
					, rs.getString("sMajor")
				);
			}
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
				if (ps != null) ps.close();
				if (rs != null) rs.close();
			} catch (SQLException e) { e.printStackTrace();}
		}
		return std;
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			ps = con.prepareStatement(sql);

			
			ps.setString(1, s.getsId());
			ps.setString(2, s.getsPw());
			ps.setString(3, s.getsName());
			ps.setInt(4, s.getsAge());
			ps.setString(5, s.getsGender());
			ps.setString(6, s.getsMajor());
			ps.setString(7, s.getsNum());

			int result = ps.executeUpdate();
			
			if (result == 1) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
				if (ps != null) ps.close();
				if (rs != null) rs.close();
			} catch (SQLException e) { e.printStackTrace();}
		}
	}

}
