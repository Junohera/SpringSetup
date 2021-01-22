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
	private JdbcTemplate template;

	@Autowired
	public ProductDao(ComboPooledDataSource ds) {
		this.template = new JdbcTemplate(ds);
	}

	public ArrayList<Product> getNewList() {
		List<Product> list = null;
		String sql = "SELECT * FROM NEW_PRO_VIEW";

		// template.query(${String sql, Constructor Method})
		list = template.query(sql, new RowMapper<Product>() {

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

		list = template.query(sql, new RowMapper<Product>() {

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
}
