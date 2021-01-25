package com.juno.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juno.shop.dto.Product;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class ProductDao {

	/**
		ComboPooledDataSource(스프링컨테이너에 수동으로 넣어놓은 클래스)에서 연결한 Connection을 jdbcTemplate에 전달,
		jdbcTemplate을 이용해 DB명령을 실행합니다.
	*/
	private JdbcTemplate tmp;

	@Autowired
	public ProductDao(ComboPooledDataSource ds) {
		this.tmp = new JdbcTemplate(ds);
	}

	public ArrayList<Product> getNewList() {
		List<Product> list = null;
		String sql = "SELECT * FROM NEW_PRO_VIEW";

		// template.query(${String sql, Constructor Method})
		list = tmp.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setPseq(rs.getInt("pseq"));
				p.setName(rs.getString("name"));
				p.setPrice2(rs.getInt("price2"));
				p.setImage(rs.getString("image"));
				return p; // list로 리턴되어 add
			}
		});
		return (ArrayList<Product>) list;
	}

	public ArrayList<Product> getBestList() {
		List<Product> list = null;
		String sql = "SELECT * FROM BEST_PRO_VIEW";

		list = tmp.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setPseq(rs.getInt("pseq"));
				p.setName(rs.getString("name"));
				p.setPrice2(rs.getInt("price2"));
				p.setImage(rs.getString("image"));
				return p; // list로 리턴되어 add
			}
		});

		return (ArrayList<Product>) list;
	}

	public List<Product> getKindList(String kind) {
		return tmp.query(
				"SELECT * FROM PRODUCT WHERE KIND = ? ORDER BY PSEQ DESC"
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
		}, kind);
	}

	public Product getProduct(int pseq) {
		return tmp.query(
				"SELECT * FROM PRODUCT WHERE PSEQ = ?"
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
		}, pseq).get(0);
	}
}
