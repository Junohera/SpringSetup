package com.juno.shop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juno.shop.dto.Product;
import com.juno.shop.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService ps;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        
        ArrayList<Product> nList = ps.getNewList();
        ArrayList<Product> bList = ps.getBestList();

        model.addAttribute("newProductList", nList);
        model.addAttribute("bestProductList", bList);

        return "index";
    }
}
