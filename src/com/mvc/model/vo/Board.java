package com.mvc.model.vo;

import java.sql.Date;

public class Board {
	
	private String div;
	private String title;
	private String comments;
	private String writer;
	private Date write_date;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	@Override
	public String toString() {
		return div+"\t"+title+"\t"+comments+"\t\t\t"+writer+"\t"+write_date;
	}
	
	

}
