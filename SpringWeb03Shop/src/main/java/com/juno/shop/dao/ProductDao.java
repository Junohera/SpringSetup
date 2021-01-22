package com.juno.shop.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.juno.shop.dto.Product;

@Repository
public class ProductDao {

	// ComboPooledDataSource(스프링컨테이너에 수동으로 넣어놓은 클래스)에서 연결한 Connection을 jdbcTemplate에 전달,
	// jdbcTemplate을 이용해 DB명령을 실행합니다.
	private jdbcTemplate template;

	@Autowired
	public ProductDao(ComboPooledDataSource ds) {
		this.template = new JdbcTemplate(ds);
	}

	public ArrayList<Product> getNewList() {
		return null;
	}

	public ArrayList<Product> getBestList() {
		return null;
	}
}
