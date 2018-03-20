package com.database.model;

import java.io.Serializable;
import java.util.Date;

//공지사항
public class Notice implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer no;			//primary key
	private String title;		//공지사항 제목
    private String description;	//내용
    private Date showTime;		//게임상에서 보여질 시간(게임공지용)
    private Date endTime;		//게임상에서 끝나는 시간(게임공지용)
    private String type;		//게임 공지 타입(B : 게시판형, G : 게임 공지용)
	private Date regDate; 		//등록시간
	private String link;		//링크가 존재할 경우 링크 주소
	private String writer;		//작성자 id(Admin)
    private Integer gameNo;		//게임넘버(0:전체공지, 아닐경우 게임NO 입력)
	
	public Notice() {		
	}

	public Notice(Integer no, String title, String description, Date showTime, Date endTime, String type, Date regDate, String link, String writer, Integer gameNo) {
		this.no = no;
		this.title = title;
		this.description = description;
		this.showTime = showTime;
		this.endTime = endTime;
		this.type = type;
		this.regDate = regDate;
		this.link = link;
		this.writer = writer;
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

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
		builder.append(", showTime=");
		builder.append(showTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", type=");
		builder.append(type);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", link=");
		builder.append(link);
		builder.append(", writer=");
		builder.append(writer);
		builder.append("]");
		return builder.toString();
	}
	
}
