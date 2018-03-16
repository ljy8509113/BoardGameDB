package com.database.model;

import java.io.Serializable;

public class SubImage implements Serializable {
	private static final long serialVersionUID = 1L;
	private int no;			//id
	private String path;	// 이미지 경로
	private int gameNo;		// 게임 no
	
	public SubImage() {
		
	}
	
	public SubImage(int no, String path, int gameNo) {
		super();
		this.no = no;
		this.path = path;
		this.gameNo = gameNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	
	
}
