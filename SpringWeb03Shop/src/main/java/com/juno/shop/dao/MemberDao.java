package com.juno.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juno.shop.dto.Address;
import com.juno.shop.dto.Member;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class MemberDao {

    private JdbcTemplate tmp;

    @Autowired
    public MemberDao(ComboPooledDataSource ds) {
        tmp = new JdbcTemplate();
        tmp.setDataSource(ds);
    }

	public Member getMember(String id) {
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
        List<Member> list = tmp.query(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member m = new Member();
                m.setId(rs.getString("id"));
                m.setPwd(rs.getString("pwd"));
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setZip_num(rs.getString("zip_num"));
                m.setAddress(rs.getString("address"));
                m.setPhone(rs.getString("phone"));
                m.setUseyn(rs.getString("useyn"));
                m.setIndate(rs.getTimestamp("indate"));
                return m;
            }
        }, id);
        
        if (list.size() == 0) {
        	return null;
        } else {
        	return list.get(0);        	
        }
	}

	public int confirmId(String id) {
        int result = -1;
        String sql = "SELECT * FROM MEMBER WHERE ID = ?";
        List<Member> list = null;
        list = tmp.query(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member m = new Member();
                m.setId(rs.getString("id"));
                m.setPwd(rs.getString("pwd"));
                return m;
            }
        }, id);

        if (list.size() == 0) {
            result = 1; // 사용 가능
        } else {
            result = 0; // 이미 존재
        }

        return result;
	}

	public List<Address> selectAddressByDong(String dong) {
		List<Address> list = tmp.query(
				"SELECT * FROM ADDRESS WHERE DONG LIKE '%'||?||'%'"
				, new RowMapper<Address>() {
					@Override
					public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
						Address a = new Address();
						a.setZip_num(rs.getString("ZIP_NUM"));
						a.setSido(rs.getString("SIDO"));
						a.setGugun(rs.getString("GUGUN"));
						a.setDong(rs.getString("DONG"));
						a.setZip_code(rs.getString("ZIP_CODE"));
						a.setBunji(rs.getString("BUNJI"));
					
						return a;
					}
		}, dong);
		return list;
	}

	public void insertMember(Member m) {
        tmp.update(
            "INSERT INTO MEMBER(ID, PWD, NAME, ZIP_NUM, ADDRESS, EMAIL, PHONE) VALUES(?, ?, ?, ?, ?, ?, ?)"
            , m.getId()
            , m.getPwd()
            , m.getName()
            , m.getZip_num()
            , m.getAddress()
            , m.getEmail()
            , m.getPhone()
        );
	}

	public void updateMember(Member m) {
		tmp.update(
            " UPDATE MEMBER SET"
            + "  PWD = ?"
            + " , NAME = ?"
            + " , ZIP_NUM = ?"
            + " , ADDRESS = ?"
            + " , EMAIL = ?"
            + " , PHONE = ?"
            +" WHERE ID = ?"
        , m.getPwd()
        , m.getName()
        , m.getZip_num()
        , m.getAddress()
        , m.getEmail()
        , m.getPhone()
        , m.getId());
	}

	public Member getMember(String name, String phone) {
		Member m = null;
		List<Member> list = null;
        list = tmp.query("SELECT * FROM MEMBER WHERE NAME = ? AND PHONE = ?",
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member m = new Member();
                m.setId(rs.getString("id"));
                m.setPwd(rs.getString("pwd"));
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setZip_num(rs.getString("zip_num"));
                m.setAddress(rs.getString("address"));
                m.setPhone(rs.getString("phone"));
                m.setUseyn(rs.getString("useyn"));
                m.setIndate(rs.getTimestamp("indate"));
                return m;
			}
		}, name, phone);
        
        if (list.size() > 0) {
        	m = list.get(0);
        }
        return m;
	}

	public Member getMember(String id, String name, String phone) {
		Member m = null;
		List<Member> list = null;
        list = tmp.query("SELECT * FROM MEMBER WHERE ID = ? AND NAME = ? AND PHONE = ?",
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member m = new Member();
                m.setId(rs.getString("id"));
                m.setPwd(rs.getString("pwd"));
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setZip_num(rs.getString("zip_num"));
                m.setAddress(rs.getString("address"));
                m.setPhone(rs.getString("phone"));
                m.setUseyn(rs.getString("useyn"));
                m.setIndate(rs.getTimestamp("indate"));
                return m;
			}
		}, id, name, phone);
        
        if (list.size() > 0) {
        	m = list.get(0);
        }
        return m;
	}

    public void resetPw(Member m) {
        tmp.update(
            " UPDATE MEMBER SET"
            + " PWD = ?"
            + " WHERE ID = ?"
        , m.getPwd(), m.getId());
    }
    
}
