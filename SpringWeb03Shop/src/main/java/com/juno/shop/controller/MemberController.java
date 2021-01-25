package com.juno.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juno.shop.dto.Address;
import com.juno.shop.dto.Member;
import com.juno.shop.service.MemberService;

@Controller
public class MemberController {
    
    @Autowired
    MemberService ms;

    @RequestMapping(value = "/findIdStep1")
    public String findIdStep1(Model model, HttpServletRequest request) {
        return "member/findIdPwFormStep1"; // 이름, 전화번호 입력폼
    }

    @RequestMapping(value = "/findIdStep2", method = RequestMethod.POST)
    public ModelAndView findIdStep2(Model model, HttpServletRequest request
            , @RequestParam("name") String name
            , @RequestParam("phone") String phone
            ) {

        ModelAndView mv = new ModelAndView();
        Member m = ms.findId(name, phone);
        if (m == null) {
            mv.addObject("message", "없는 유저입니다");
            mv.setViewName("member/findIdPwFormStep1");
        } else {
            mv.addObject("name", name);
            mv.addObject("phone", phone);
            mv.setViewName("member/findIdPwFormStep3"); // 인증번호 입력창
        }
        return mv;
    }

    @RequestMapping(value = "/findIdStep3")
    public ModelAndView findIdStep3(Model model, HttpServletRequest request
            , @RequestParam("accessNum") String accessNum
            , @RequestParam("name") String name
            , @RequestParam("phone") String phone
            ) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("phone", phone);
        mv.setViewName("member/findIdPwFormStep3");

        if (accessNum == null || accessNum.equals("")) {
        } else {
            // 입력값 존재
            if (accessNum.equals("1234")) {// 임시번호 "1234"
                // 인증번호 일치
            	Member m =  ms.findId(name, phone);
            	if (m != null) {
            		mv.addObject("result", m.getId());	
            	} else {
            		mv.addObject("message", "회원 찾기 도중 데이터가 변경되었습니다. 관리자에게 문의하세요");
            	}
                
            } else {
                // 인증번호 불일치
                mv.addObject("message", "발급된 인증번호가 다릅니다");
            }
        }

        return mv; 
    }


    @RequestMapping(value = "/findIdPw")
    public String findIdPw(Model model, HttpServletRequest request) {
        return "member/findIdPwForm";
    }
    
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
