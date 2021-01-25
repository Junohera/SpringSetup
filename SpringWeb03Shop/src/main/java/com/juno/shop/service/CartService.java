package com.juno.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.shop.dao.CartDao;
import com.juno.shop.dto.Cart;

@Service
public class CartService {
	
	@Autowired
	CartDao cd;

	public void insertCart(Cart c) {
		cd.insertCart(c);		
	}

	public List<Cart> listCart(String id) {
		return cd.listCart(id);
	}

	public void deleteCart(String cseq) {
		cd.deletCart(cseq);
	}
	
	
}
