package com.database.model;

import java.io.Serializable;
import java.util.Date;

//공지사항
public class Notice implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer no;			//primary key
	private String title;		//공지사항 제목
    private String description;	//내용
    private Date regDate; 		//등록시간
	private Integer gameNo;		//게임넘버(0:전체공지, 아닐경우 게임NO 입력)
	
	public Notice() {		
	}

	public Notice(Integer no, String title, String description, Date regDate, Integer gameNo) {
		this.no = no;
		this.title = title;
		this.description = description;
		this.regDate = regDate;
		this.gameNo = gameNo;
	}
	
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
		
	public Integer getGameNo() {
		return gameNo;
	}

	public void setGameNo(Integer gameNo) {
		this.gameNo = gameNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notice [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	
}
