package com.database.model;

import java.io.Serializable;

//사용자
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String email;		//가입 이메일(id)
	private String nickname;	//보여질 닉네임
	private boolean isAutoId;
	private int point;
	
	public User() {		
	}
	
	public User(String email, String nickName) {
		this.email = email;
		this.nickname = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean getIsAutoId() {
		return isAutoId;
	}

	public void setIsAutoId(boolean isAutoId) {
		this.isAutoId = isAutoId;
	}
	
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", nickname=" + nickname + ", isAutoId=" + isAutoId + ", point=" + point + "]";
	}

	public void updatePoint(int addPoint) {
		point += addPoint;
	}

	
}
