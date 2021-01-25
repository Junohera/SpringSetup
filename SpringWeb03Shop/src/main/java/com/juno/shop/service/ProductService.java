package com.juno.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.shop.dao.ProductDao;
import com.juno.shop.dto.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao pdao;

	public ArrayList<Product> getNewList() {
		return pdao.getNewList();
	}

	public ArrayList<Product> getBestList() {
		return pdao.getBestList();
	}

	public List<Product> getKindList(String kind) {
		return pdao.getKindList(kind);
	}

	public Product getProduct(int pseq) {
		return pdao.getProduct(pseq);
	}
	
}
