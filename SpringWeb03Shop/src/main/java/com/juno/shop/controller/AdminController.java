package com.juno.shop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juno.shop.dto.Member;
import com.juno.shop.dto.Order;
import com.juno.shop.dto.Paging;
import com.juno.shop.dto.Product;
import com.juno.shop.dto.Qna;
import com.juno.shop.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    AdminService as;

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin/adminLoginForm";
    }

    @RequestMapping(value = "adminLogin", method = RequestMethod.POST)
    public ModelAndView adminLogin(Model model, HttpServletRequest request
            , @RequestParam("workId") String workId
            , @RequestParam("workPwd") String workPwd
            ) {
        ModelAndView mv = new ModelAndView();

        int result = as.workerCheck(workId, workPwd);
        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("workId", workId);
            mv.setViewName("redirect:/adminProductList");
        } else if (result == 0) {
            mv.addObject("message", "비밀번호를 확인하세요");
            mv.setViewName("admin/adminLoginForm");
        } else if (result == -1) {
            mv.addObject("message", "아이디를 확인하세요");
            mv.setViewName("admin/adminLoginForm");
        }

        return mv;
    }

    @RequestMapping(value = "adminProductList")
    public ModelAndView productList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }

            String searchType = "NAME";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt("PRODUCT", searchType, key);
			paging.setTotalCount(totalCount);

            ArrayList<Product> productList = as.selectProduct(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("productList", productList);
            mv.setViewName("admin/product/productList");
        }
        
        return mv;
    }

    @RequestMapping(value = "/adminOrderList")
    public ModelAndView orderList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }

            String searchType = "MNAME";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt("ORDER_VIEW", searchType, key);
			paging.setTotalCount(totalCount);

            ArrayList<Order> orderList = as.selectOrder(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("orderList",orderList);
            mv.setViewName("admin/order/orderList");
        }

        return mv;
    }

    @RequestMapping(value = "/adminMemberList")
    public ModelAndView memberList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }

            String searchType = "NAME";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt("MEMBER", searchType, key);
			paging.setTotalCount(totalCount);

            ArrayList<Member> memberList = as.selectMember(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("memberList",memberList);
            mv.setViewName("admin/member/memberList");
        }
        
        return mv;
    }

    @RequestMapping(value = "/adminQnaList")
    public ModelAndView qnaList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }

            String searchType = "SUBJECT";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt("QNA", searchType, key);
			paging.setTotalCount(totalCount);

            ArrayList<Qna> qnaList = as.selectQna(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("qnaList", qnaList);
            mv.setViewName("admin/qna/qnaList");
        }
        
        return mv;
    }

}
