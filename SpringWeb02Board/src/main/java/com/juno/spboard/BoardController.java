package com.juno.spboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juno.spboard.dto.SpBoard;
import com.juno.spboard.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping("/boardView")
	public String boardView(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
			
		SpBoard b = bs.boardView(num);
		model.addAttribute("b", b);
		return "boardView";
	}
	
	@RequestMapping("/main")
	public String main(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			return "loginForm";
		} else {
			ArrayList<SpBoard> list = bs.selectBoardAll();
			model.addAttribute("boardList", list);
			return "main";
		}
	}
}
