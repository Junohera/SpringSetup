package com.juno.spboard.dto;

import java.sql.Timestamp;

public class Reply {
    private int num;
    private int boardnum;
    private String userid;
    private Timestamp writedate;
    private String content;
	@Override
	public String toString() {
		return "Reply [num=" + num + ", boardnum=" + boardnum + ", userid=" + userid + ", writedate=" + writedate
				+ ", content=" + content + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
