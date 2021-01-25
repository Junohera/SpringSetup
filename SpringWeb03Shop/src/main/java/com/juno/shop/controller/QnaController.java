package com.juno.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juno.shop.dto.Member;
import com.juno.shop.dto.Qna;
import com.juno.shop.service.QnaService;

@Controller
public class QnaController {
	
	@Autowired
	QnaService qs;

	@RequestMapping(value = "/qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(Model model, HttpServletRequest request
			, @RequestParam("subject") String subject
			, @RequestParam("content") String content) {
		ModelAndView mv = new ModelAndView();
		Member m = (Member) request.getSession().getAttribute("loginUser");
		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			Qna q = new Qna();
			q.setSubject(subject);
			q.setContent(content);
			q.setId(m.getId());
			qs.insertQna(q);
			mv.setViewName("redirect:/qnaList");
		}
		
		return mv;
	}

	@RequestMapping(value = "qnaWriteForm", method = RequestMethod.GET)
	public String qnaWriteForm(Model model, HttpServletRequest request) {
		if ((Member) request.getSession().getAttribute("loginUser") == null) {
			return "member/login";
		}
		else {
			return "qna/qnaWriteForm";	
		}
	}

	@RequestMapping(value = "/qnaView", method = RequestMethod.GET)
	public ModelAndView qnaView(Model model, HttpServletRequest request
			, @RequestParam("qseq") int qseq) {
		ModelAndView mv = new ModelAndView();
		
		Member m = (Member) request.getSession().getAttribute("loginUser");
		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			mv.addObject("q", qs.getQna(qseq));
			mv.setViewName("qna/qnaView");	
		}
		
		return mv;
	}

	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Member m = (Member) request.getSession().getAttribute("loginUser");

		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			List<Qna> qnaList = qs.listQna(m.getId());
			mv.addObject("qnaList", qnaList);
			mv.setViewName("qna/qnaList");
		}
		
		return mv;
	}

}
