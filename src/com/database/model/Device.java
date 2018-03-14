package com.database.model;

import java.io.Serializable;

//사용자 디바이스 정보
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;		//사용자 email
    private String uuid;		//디바이스 uuid
    private String os;			//디바이스 os 종류 : android, ios
    private String version;		//os 버전
    
    public Device() {    	
    }
    
	public Device(String email, String uuid, String os, String version) {
		this.email = email;
		this.uuid = uuid;
		this.os = os;
		this.version = version;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Device [email=");
		builder.append(email);
		builder.append(", uuid=");
		builder.append(uuid);
		builder.append(", os=");
		builder.append(os);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}
    
}
