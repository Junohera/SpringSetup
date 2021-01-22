package com.juno.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juno.shop.dto.Address;
import com.juno.shop.dto.Member;
import com.juno.shop.service.MemberService;

@Controller
public class MemberController {
    
    @Autowired
    MemberService ms;
    
    @RequestMapping(value = "/memberEdit", method = RequestMethod.POST)
    public String memberEdit(Model model, HttpServletRequest request) {
        Member m = new Member();
        m.setId(request.getParameter("id"));
        m.setPwd(request.getParameter("pwd"));
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setZip_num(request.getParameter("zip_num"));
        m.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
        m.setPhone(request.getParameter("phone"));
        ms.updateMember(m);
        
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", m);
        
        return "redirect:/";
    }

    @RequestMapping(value = "/memberEditForm", method = RequestMethod.GET)
    public String memberEditForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member m = (Member) session.getAttribute("loginUser");

        String addr = m.getAddress();
        try {
        	int k1 = addr.indexOf(" ");
            int k2 = addr.indexOf(" ", k1+1);
            int k3 = addr.indexOf(" ", k2+1);

            String addr1 = addr.substring(0, k3);
            String addr2 = addr.substring(k3+1);
            
            model.addAttribute("addr1", addr1);
            model.addAttribute("addr2", addr2);
        } catch(Exception e) {
        	model.addAttribute("addr1", "");
            model.addAttribute("addr2", "");
        }

        model.addAttribute("m", m);
        

        return "member/editForm";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(Model model, HttpServletRequest request) {
        Member m = new Member();
        m.setId(request.getParameter("id"));
        m.setPwd(request.getParameter("pwd"));
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPhone(request.getParameter("phone"));
        m.setZip_num(request.getParameter("zip_num"));
        m.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
        ms.insertMember(m);
        return "member/login";
    }    

    @RequestMapping(value = "/findZipNum")
    public String findZipNum(Model model, HttpServletRequest request) {
        String dong = request.getParameter("dong");
        if ((dong != null && dong.trim().equals("")) == false) {
            List<Address> addressList = ms.selectAddressByDong(dong);
            model.addAttribute("addressList", addressList);
        }
        return "member/findZipNum";
    }

    @RequestMapping(value = "/idCheckForm")
    public String idCheckForm(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        int result = ms.confirmId(id);
        model.addAttribute("result", result);
        model.addAttribute("id", id);
        return "member/idCheck";
    }

    @RequestMapping(value = "/joinForm", method = RequestMethod.POST)
    public String joinForm(Model model, HttpServletRequest request) {
        return "member/joinForm";
    }

    @RequestMapping(value = "contract")
    public String contract(Model model, HttpServletRequest request) {
        return "member/contract";
    }

    @RequestMapping(value = "logout")
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser"); // 다른 세션값(관리자)유지를 위해 loginUser만 제거
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        Member m = ms.getMember(id);

        if (m != null) {
        	if (m.getPwd() != null) {
        		if (m.getPwd().equals(pwd)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loginUser", m);
                    return "redirect:/";
                } else model.addAttribute("message", "no match password");	
        	} else model.addAttribute("message", "invalid user info, call admin");
        } else model.addAttribute("message", "no id");

        return "member/login";
    }

    @RequestMapping(value = "/loginForm")
    public String loginForm(Model model, HttpServletRequest request) {
        return "member/login";
    }
}
