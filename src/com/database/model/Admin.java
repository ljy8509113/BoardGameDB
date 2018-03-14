package com.database.model;

import java.io.Serializable;

//관리자 계정
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;			//계정 id
	private String password;	//비밀번호
	private String nickName;	//보여질 닉네임
	private Integer failCount;	//로그인 실패 횟수
	
	public Admin() {		
	}
	
	public Admin(String id, String password, String nickName, Integer failCount) {
		this.id = id;
		this.password = password;
		this.nickName = nickName;
		this.failCount = failCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}
	
	
}
