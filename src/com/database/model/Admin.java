package com.database.model;

import java.io.Serializable;
import java.util.Set;


//관리자 계정
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;			//계정 id
	private String password;	//비밀번호
	private String nickName;	//보여질 닉네임
	private Integer failCount;	//로그인 실패 횟수
	private Set<Authority> authoriites;		// 해당 관리자의 권한 목록
	
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

	public Set<Authority> getAuthoriites() {
		return authoriites;
	}

	public void setAuthoriites(Set<Authority> authoriites) {
		this.authoriites = authoriites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authoriites == null) ? 0 : authoriites.hashCode());
		result = prime * result + ((failCount == null) ? 0 : failCount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
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
		builder.append(nickName);
		builder.append(", failCount=");
		builder.append(failCount);
		builder.append(", authoriites=");
		builder.append(authoriites);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
}
