package com.juno.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juno.shop.dto.Member;
import com.juno.shop.dto.Order;
import com.juno.shop.dto.Paging;
import com.juno.shop.dto.Product;
import com.juno.shop.dto.Qna;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class AdminDao {

    private JdbcTemplate tmp;
	
	@Autowired
	public AdminDao(ComboPooledDataSource ds) {
		tmp = new JdbcTemplate();
		tmp.setDataSource(ds);
	}

	public int workerCheck(String workId, String workPwd) {
		List<String> list = null;
		list = tmp.query(
			"SELECT PWD FROM WORKER WHERE ID = ?"
			, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("pwd");
			}
		}, workId);
		
		int result = 0;
		if (list.size() == 0) {
			result = -1;
		} else if (list.get(0).equals(workPwd)) {
			result = 1;
		} else {
			result = 0;
		}
		
		return result;
	}

	public int selectTotalCnt(String tableName, String searchType, String searchWord) {
		return tmp.query(
				"SELECT COUNT(*) AS TOTAL_COUNT FROM " + tableName + " WHERE ? LIKE '%'||?||'%'"
				, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("TOTAL_COUNT");
			}
			
		}, searchType, searchWord).get(0);
	}

	public ArrayList<Product> selectProduct(Paging paging, String searchType, String key) {
		return (ArrayList<Product>) tmp.query(""
				+ " SELECT * FROM ("
				+ " SELECT * FROM ("
				+ " SELECT ROWNUM AS RN, P.* FROM (("
				+ " SELECT * FROM PRODUCT WHERE " + searchType + " LIKE '%'||?||'%' ORDER BY PSEQ DESC) P))"
				+ " WHERE RN >= ?)"
				+ " WHERE RN <= ?"
				, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setPseq(rs.getInt("pseq"));
				p.setName(rs.getString("name"));
				p.setKind(rs.getString("kind"));
				p.setPrice1(rs.getInt("price1"));
				p.setPrice2(rs.getInt("price2"));
				p.setPrice3(rs.getInt("price3"));
				p.setContent(rs.getString("content"));
				p.setImage(rs.getString("image"));
				p.setUseyn(rs.getString("useyn"));
				p.setBestyn(rs.getString("bestyn"));
				p.setIndate(rs.getTimestamp("indate"));
				
				return p;
			}
		}, key, paging.getStartNum(), paging.getEndNum());
	}

	public ArrayList<Order> selectOrder(Paging paging, String searchType, String key) {
		return (ArrayList<Order>) tmp.query(""
				+ " SELECT * FROM ("
				+ " SELECT * FROM ("
				+ " SELECT ROWNUM AS RN, P.* FROM (("
				+ " SELECT * FROM ORDER_VIEW WHERE " + searchType + " LIKE '%'||?||'%' ORDER BY RESULT, OSEQ DESC) P))"
				+ " WHERE RN >= ?)"
				+ " WHERE RN <= ?"
				, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order o = new Order();
				o.setOdseq(rs.getInt("odseq"));
				o.setOseq(rs.getInt("oseq"));
				o.setId(rs.getString("id"));
				o.setIndate(rs.getTimestamp("indate"));
				o.setMname(rs.getString("mname"));
				o.setZip_num(rs.getString("zip_num"));
				o.setAddress(rs.getString("address"));
				o.setPhone(rs.getString("phone"));
				o.setPseq(rs.getInt("pseq"));
				o.setQuantity(rs.getInt("quantity"));
				o.setPname(rs.getString("pname"));
				o.setPrice2(rs.getInt("price2"));
				o.setResult(rs.getString("result"));
				
				return o;
			}
		}, key, paging.getStartNum(), paging.getEndNum());
	}

	public ArrayList<Member> selectMember(Paging paging, String searchType, String key) {
		return (ArrayList<Member>) tmp.query(""
				+ " SELECT * FROM ("
				+ " SELECT * FROM ("
				+ " SELECT ROWNUM AS RN, P.* FROM (("
				+ " SELECT * FROM MEMBER WHERE " + searchType + " LIKE '%'||?||'%' ORDER BY INDATE DESC) P))"
				+ " WHERE RN >= ?)"
				+ " WHERE RN <= ?"
				, new RowMapper<Member>() {
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
		}, key, paging.getStartNum(), paging.getEndNum());
	}

	public ArrayList<Qna> selectQna(Paging paging, String searchType, String key) {
		return (ArrayList<Qna>) tmp.query(""
				+ " SELECT * FROM ("
				+ " SELECT * FROM ("
				+ " SELECT ROWNUM AS RN, P.* FROM (("
				+ " SELECT * FROM QNA WHERE " + searchType + " LIKE '%'||?||'%' ORDER BY QSEQ DESC) P))"
				+ " WHERE RN >= ?)"
				+ " WHERE RN <= ?"
				, new RowMapper<Qna>() {
			@Override
			public Qna mapRow(ResultSet rs, int rowNum) throws SQLException {
				Qna q = new Qna();
				q.setQseq(rs.getInt("qseq"));
				q.setSubject(rs.getString("subject"));
				q.setContent(rs.getString("content"));
				q.setId(rs.getString("id"));
				q.setIndate(rs.getTimestamp("indate"));
				q.setReply(rs.getString("reply"));
				q.setRep(rs.getString("rep"));
				
				return q;
			}
		}, key, paging.getStartNum(), paging.getEndNum());
	}
}
