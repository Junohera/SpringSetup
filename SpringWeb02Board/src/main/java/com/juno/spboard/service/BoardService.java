package com.juno.spboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.spboard.dao.BoardDao;
import com.juno.spboard.dto.SpBoard;

@Service
public class BoardService {
	
	@Autowired
	BoardDao bd;

	public ArrayList<SpBoard> selectBoardAll() {
		return bd.selectBoardAll();
	}

	public SpBoard boardView(int num) {
		bd.increaseReadCount(num);
		return bd.selectBoard(num);
	}
	
}
