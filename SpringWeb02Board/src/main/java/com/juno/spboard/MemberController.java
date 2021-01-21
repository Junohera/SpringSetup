package com.juno.spboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juno.spboard.dto.SpMember;
import com.juno.spboard.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping(value = "logout")
	public String logout(Model model, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "memberEdit", method=RequestMethod.POST)
	public String memberEdit(Model model, HttpServletRequest request) {
		SpMember m = new SpMember();
		m.setId(request.getParameter("id"));
		m.setPw(request.getParameter("pw"));
		m.setName(request.getParameter("name"));
		m.setPhone1(request.getParameter("phone1"));
		m.setPhone2(request.getParameter("phone2"));
		m.setPhone3(request.getParameter("phone3"));
		m.setEmail(request.getParameter("email"));
		int result = ms.memberModify(m);

		if (result == 1) {
			request.getSession().setAttribute("loginUser", m);
		}
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "memberEditForm")
	public String memberEditForm(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) return "loginForm";
		return "editForm";
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(Model model, HttpServletRequest request) {
		SpMember m = new SpMember();		
		m.setId(request.getParameter("id"));
		m.setPw(request.getParameter("pw"));
		m.setName(request.getParameter("name"));
		m.setPhone1(request.getParameter("phone1"));
		m.setPhone2(request.getParameter("phone2"));
		m.setPhone3(request.getParameter("phone3"));
		m.setEmail(request.getParameter("email"));
		ms.memberRegister(m);
		
		return "loginForm";
	}
	
	@RequestMapping(value = "idcheck")
	public String idcheck(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		int result = ms.confirmId(id);
		model.addAttribute("result", result);
		model.addAttribute("id", id);
		return "idcheck";
	}
	
	@RequestMapping(value = "memberJoinForm")
	public String joinForm(Model model) {
		return "joinForm";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String url = "loginForm"; // 최종목적지는 loginForm.jsp이지만 로그인성공시 main.jsp로 url이 수정될 예정
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		SpMember m = ms.getMember(id);
		
		if (m == null) {
			model.addAttribute("message", "id not found");
		}
		else if (!m.getPw().equals(pw)) {
			model.addAttribute("message", "check pw");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", m);
			url = "redirect:/main"; // main.jsp로 안가고 request:"main"을 찾아 갑니다.
		}
		return url;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			return "loginForm";
		} else {
			return "main";
		}
	}
}
