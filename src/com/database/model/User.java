package com.database.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

//사용자
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String email;		//가입 이메일(id)
	private String nickname;	//보여질 닉네임
	
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [email=");
		builder.append(email);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append("]");
		return builder.toString();
	}
	
}
