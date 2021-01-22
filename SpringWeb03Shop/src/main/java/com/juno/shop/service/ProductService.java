package com.juno.shop.service;

import java.util.ArrayList;

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
	
}
