package com.daniel.model;

import java.util.Date;

public class Board {
	private int boardid;
	private String title;
	private String writer;
	private Date date;
	private String memo;
	
	
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Board [boardid=" + boardid + ", title=" + title + ", writer=" + writer + ", date=" + date + ", memo="
				+ memo + "]";
	}
	
}
