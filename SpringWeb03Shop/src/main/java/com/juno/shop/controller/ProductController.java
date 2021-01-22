package com.juno.shop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juno.shop.dto.Product;
import com.juno.shop.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService ps;
    
    @RequestMapping(value = "/category")
    public ModelAndView category(Model model, @RequestParam("kind") String kind) {
        /**
            ModelAndView : model에 addAttribute로 저장할 내용과 이동할 jsp파일의 이름을 동시에 저장하고
            리턴하여 전달값과 동시에 이동페이지를 한번에 다루는 클래스.
            @RequestParam: 메서드의 전달인수 앞에 붙여서 사용하며, request.getParameter없이 전달받아 사용합니다.
            - 갯수만큼 매개변수를 만들고 모든 전달인수에 적용할 수 있습니다.
        */
        ModelAndView mv = new ModelAndView();
        mv.addObject("productKindList", ps.getKindList(kind));
        mv.setViewName("product/productKind");
        return mv;
    }

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        
        ArrayList<Product> nList = ps.getNewList();
        ArrayList<Product> bList = ps.getBestList();

        model.addAttribute("newProductList", nList);
        model.addAttribute("bestProductList", bList);

        return "index";
    }
}
