package com.juno.spboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.spboard.dao.BoardDao;
import com.juno.spboard.dto.Paging;
import com.juno.spboard.dto.Reply;
import com.juno.spboard.dto.SpBoard;

@Service
public class BoardService {
	
	@Autowired
	BoardDao bd;

	public ArrayList<SpBoard> selectBoardAll(Paging paging) {
		return bd.selectBoardAll(paging);
	}

	public int selectBoardAllCount() {
		return bd.selectBoardAllCount();
	}

	public SpBoard boardView(int num) {
		bd.increaseReadCount(num);
		return bd.selectBoard(num);
	}

	public void boardWrite(SpBoard b) {
		bd.insertBoard(b);
	}

	public SpBoard getBoard(int num) {
		return bd.selectBoard(num);
	}

	public void boardUpdate(SpBoard b) {
		bd.updateBoard(b);		
	}

	public void boardDelete(int num) {
		bd.deleteBoard(num);
	}

	public ArrayList<Reply> selectReply(int num) {
		return bd.selectReply(num);
	}

	public void deleteReply(int num) {
		bd.deleteReply(num);
	}

	public void addReply(Reply r) {
		bd.addReply(r);
	}
	
}
