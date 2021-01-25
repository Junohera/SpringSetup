package com.juno.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juno.shop.dto.Cart;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class CartDao {
	
	private JdbcTemplate tmp;
	
	@Autowired
	public CartDao(ComboPooledDataSource ds) {
		tmp = new JdbcTemplate();
		tmp.setDataSource(ds);
	}

	public void insertCart(Cart c) {
		String sql = "INSERT INTO CART(CSEQ, ID, PSEQ, QUANTITY) VALUES (CART_SEQ.NEXTVAL, ?, ?, ?)";
		tmp.update(sql, c.getId(), c.getPseq(), c.getQuantity());
	}

	public List<Cart> listCart(String id) {
		List<Cart> list = null;
		String sql = "SELECT * FROM CART_VIEW WHERE ID = ? AND RESULT = '1' ORDER BY CSEQ DESC";
		list = tmp.query(sql, 
				new RowMapper<Cart>() {
					
				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart c = new Cart();
					c.setCseq(rs.getInt("cseq"));
					c.setId(rs.getString("id"));
					c.setPseq(rs.getInt("pseq"));
					c.setMname(rs.getString("mname"));
					c.setPname(rs.getString("pname"));
					c.setQuantity(rs.getInt("quantity"));
					c.setPrice2(rs.getInt("price2"));
					c.setIndate(rs.getTimestamp("indate"));
					return c;
				}
		}, id);
		return list;
	}

	public void deletCart(String cseq) {
		tmp.update("DELETE FROM CART WHERE CSEQ = ?", cseq);
	}
}
