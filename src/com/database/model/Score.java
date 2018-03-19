package com.database.model;

import java.io.Serializable;

//전적
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;		//사용자 email
	private int total;			//총 게임수
	private int win;			//승리 수
	private int lose;			//패배 수
	private int disconnect;		//경기중 연결이 끊겨서 참여하지 못한 횟수
	private int gameNo;			//게임 no
	
	public Score() {		
	}
	
	public Score(String email, int total, int win, int lose, int disconnect, int gameNo) {
		this.email = email;
		this.total = total;
		this.win = win;
		this.lose = lose;
		this.disconnect = disconnect;
		this.gameNo = gameNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDisconnect() {
		return disconnect;
	}

	public void setDisconnect(int disconnect) {
		this.disconnect = disconnect;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("History [email=");
		builder.append(email);
		builder.append(", total=");
		builder.append(total);
		builder.append(", win=");
		builder.append(win);
		builder.append(", lose=");
		builder.append(lose);
		builder.append(", disconnect=");
		builder.append(disconnect);
		builder.append(", gameNo=");
		builder.append(gameNo);
		builder.append("]");
		return builder.toString();
	}
	
}
