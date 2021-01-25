package com.juno.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juno.shop.dto.Cart;
import com.juno.shop.dto.Order;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class OrderDao {
	
	private JdbcTemplate tmp;
	
	@Autowired
	public OrderDao(ComboPooledDataSource ds) {
		tmp = new JdbcTemplate();
		tmp.setDataSource(ds);
	}

	public void insertOrders(String id) {
		String sql = "INSERT INTO ORDERS(OSEQ, ID) VALUES(ORDERS_SEQ.NEXTVAL, ?)";
		tmp.update(sql, id);
	}

	public int getMaxOseq() {
		return tmp.query(
				"SELECT MAX(OSEQ) AS MAX_OSEQ FROM ORDERS"
				, new RowMapper<Integer>() {
					
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getInt("MAX_OSEQ");
					}
		}).get(0);
	}

	public void insertOrderDetail(Cart c, int oseq) {
		tmp.update(
				"INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, ?, ?, ?)"
				, oseq
				, c.getPseq()
				, c.getQuantity()
		);
	}
	
	public List<Order> selectOrderDetail(int masterOseq) {
		return tmp.query(
				"SELECT * FROM ORDER_VIEW WHERE OSEQ = ? ORDER BY OSEQ DESC"
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
						o.setPname(rs.getString("pname"));
						o.setQuantity(rs.getInt("quantity"));
						o.setPrice2(rs.getInt("price2"));
						o.setResult(rs.getString("result"));
						return o;
					}
		}, masterOseq);
	}

	public void updateCart(Cart c) {
		tmp.update(
				"UPDATE CART SET RESULT = '2' WHERE CSEQ = ?"
				, c.getCseq()
		);
	}
	
	public List<Integer> orderMasterById(String id) {
		return tmp.query(
				"SELECT DISTINCT OSEQ FROM ORDER_VIEW WHERE ID = ? ORDER BY OSEQ DESC"
				, new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getInt("oseq");
					}
		}, id);
	}
	
	public List<Integer> orderMasterByIdAndResult(String id, String result) {
		return tmp.query(
				"SELECT DISTINCT OSEQ FROM ORDER_VIEW WHERE ID = ? AND RESULT LIKE '%'||?||'%' ORDER BY OSEQ DESC"
				, new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getInt("oseq");
					}
		}, id, result);
	}

	public List<Order> listOrderById(String id, String result, int oseq) {
		return tmp.query(
				"SELECT * FROM ORDER_VIEW WHERE ID = ? AND RESULT LIKE '%'||?||'%' AND OSEQ = ?"
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
						o.setPname(rs.getString("pname"));
						o.setQuantity(rs.getInt("quantity"));
						o.setPrice2(rs.getInt("price2"));
						o.setResult(rs.getString("result"));
						return o;
					}
		}, id, result, oseq);
	}

}
