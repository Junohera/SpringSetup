package com.juno.spboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juno.spboard.dto.Paging;
import com.juno.spboard.dto.Reply;
import com.juno.spboard.dto.SpBoard;
import com.juno.spboard.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping(value = "/addReply", method = RequestMethod.POST)
	public String addreply(Model model, HttpServletRequest request) {
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		String userid = request.getParameter("userid");
		String content = request.getParameter("content");

		Reply r = new Reply();
		r.setBoardnum(boardnum);
		r.setUserid(userid);
		r.setContent(content);
		bs.addReply(r);

		return "redirect:/boardView?num=" + boardnum;
	}
	
	

	@RequestMapping(value = "/deleteReply", method = RequestMethod.GET)
	public String deleteReply(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		bs.deleteReply(num);

		String boardnum = request.getParameter("boardnum");
		return "redirect:/boardView?num=" + boardnum;
	}

	@RequestMapping(value = "/boardDelete")
	public String boardDelete(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		bs.boardDelete(Integer.parseInt(num));
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(Model model, HttpServletRequest request) {
		SpBoard b = new SpBoard();
		int num = Integer.parseInt(request.getParameter("num"));
		b.setNum(num);
		b.setUserid(request.getParameter("userid"));
		b.setPass(request.getParameter("pass"));
		b.setEmail(request.getParameter("email"));
		b.setTitle(request.getParameter("title"));
		b.setContent(request.getParameter("content"));
		bs.boardUpdate(b);

		return "redirect:/boardView?num=" + num;
	}
	
	@RequestMapping(value = "/boardUpdateForm")
	public String boardUpdateForm(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("loginUser") == null) {
			return "loginForm";
		}
		String num = request.getParameter("num");
		SpBoard b = bs.getBoard(Integer.parseInt(num));
		System.out.println(b);
		System.out.println(b);
		model.addAttribute("b", b);
		return "boardUpdateForm";
	}

	@RequestMapping(value = "/boardDeleteForm")
	public String boardDeleteForm(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		model.addAttribute("num", num);
		return "boardCheckPassForm";
	}

	@RequestMapping(value = "/boardEdit")
	public String boardEdit(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		SpBoard b = bs.getBoard(Integer.parseInt(num));
		model.addAttribute("num", num);

		if (pass.equals(b.getPass())) {
			return "boardCheckPass";
		} else {
			model.addAttribute("message", "비밀번호가 맞지 않습니다. 확인해주세요.");
			return "boardCheckPassForm";
		}	
	}

	@RequestMapping(value = "/boardEditForm")
	public String boardEditForm(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		model.addAttribute("num", num);
		return "boardCheckPassForm";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWrite(Model model, HttpServletRequest request) {
		SpBoard b = new SpBoard();
		b.setUserid(request.getParameter("userid"));
		b.setPass(request.getParameter("pass"));
		b.setEmail(request.getParameter("email"));
		b.setTitle(request.getParameter("title"));
		b.setContent(request.getParameter("content"));

		bs.boardWrite(b);

		return "redirect:main";
	}

	@RequestMapping("/boardWriteForm")
	public String boardWriteForm(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("loginUser") == null) {
			return "loginForm";
		}
		return "boardWriteForm";
	}
	
	@RequestMapping("/boardView")
	public String boardView(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("loginUser") == null) {
			return "loginForm";
		}
		int num = Integer.parseInt(request.getParameter("num"));
			
		SpBoard b = bs.boardView(num);
		ArrayList<Reply> replyList = bs.selectReply(num);
		
		model.addAttribute("b", b);
		model.addAttribute("replyList", replyList);
		return "boardView";
	}
	
	@RequestMapping("/main")
	public String main(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			return "loginForm";
		} else {
			int page;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if (session.getAttribute("page") != null) {
				page = (int) session.getAttribute("page");
			} else {
				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(bs.selectBoardAllCount());

			ArrayList<SpBoard> list = bs.selectBoardAll(paging);
			model.addAttribute("boardList", list);
			model.addAttribute("paging", paging);
			return "main";
		}
	}
}
