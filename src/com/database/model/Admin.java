package com.database.model;

import java.io.Serializable;
import java.util.Set;


//관리자 계정
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;			//계정 id
	private String password;	//비밀번호
	private String nickname;	//보여질 닉네임
	private Integer failCount;	//로그인 실패 횟수
	private Set<Authority> authorities;		// 해당 관리자의 권한 
	
	public Admin() {		
	}
	
	public Admin(String id, String password, String nickName, Integer failCount) {
		this.id = id;
		this.password = password;
		this.nickname = nickName;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}
	
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authoriites) {
		this.authorities = authoriites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
		result = prime * result + ((failCount == null) ? 0 : failCount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Admin)) {
			return false;
		}
		 Admin other = ( Admin) obj;
		if(this.id.equals(other.id)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [id=");
		builder.append(id);
		builder.append(", password=");
		builder.append(password);
		builder.append(", nickName=");
		builder.append(nickname);
		builder.append(", failCount=");
		builder.append(failCount);
		builder.append(", authoriites=");
		builder.append(authorities);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
}
