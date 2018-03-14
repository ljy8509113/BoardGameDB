package com.database.model;

import java.io.Serializable;

//게임정보
public class Game implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer gameNo;			//게임 primary key
	private String description;		//게임 설명
	private String title;			//게임 제목
	private String coverImage;		//게임 대표 이미지
	private String state;			//게임 상태 D:개발중, O:서비스중, F:서비스종료
	private String fileName;		//프리팹경로(사용미정)
	private String version;			//게임버전
	
	public Game() {		
	}
	
	public Game(Integer gameNo, String description, String title, String coverImage, String state, String fileName, String version) {
		this.gameNo = gameNo;
		this.description = description;
		this.title = title;
		this.coverImage = coverImage;
		this.state = state;
		this.fileName = fileName;
		this.version = version;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if(other.gameNo == this.gameNo)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [gameNo=");
		builder.append(gameNo);
		builder.append(", description=");
		builder.append(description);
		builder.append(", title=");
		builder.append(title);
		builder.append(", coverImage=");
		builder.append(coverImage);
		builder.append(", state=");
		builder.append(state);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
