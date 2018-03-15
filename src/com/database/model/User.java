package com.database.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

//사용자
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String email;		//가입 이메일(id)
	private String password;	//비밀번호
	private String nickname;	//보여질 닉네임
	private Date birthday;		//생일 - 추후 연령대별 통계 쓸일 있으면 사용
	private Date joinDate;		//가입일
	private Integer failCount;	//로그인 실패 횟수-10회 이상 실패시 로그인 불가
	
	public User() {		
	}
	
	public User(String email, String password, String nickName, Date birthday) {
		this.email = email;
		this.password = password;
		this.nickname = nickName;
		this.birthday = birthday;
	}
	
	public User(String email, String password, String nickname, Date birthday, Date joinDate, Integer failCount) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.joinDate = joinDate;
		this.failCount = failCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", joinDate=");
		builder.append(joinDate);
		builder.append(", failCount=");
		builder.append(failCount);
		builder.append("]");
		return builder.toString();
	}
	
}
