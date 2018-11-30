package com.database.model;

import java.io.Serializable;

//전적
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;
	private int total;			//총 게임수
	private int win;			//승리 수
	private int lose;			//패배 수
	private int draw;		//경기중 연결이 끊겨서 참여하지 못한 횟수
	private int gameNo;			//게임 no
	private String nickName;	//사용자 닉네임
	
	public Score() {		
	}
	
	public Score(int total, int win, int lose, int draw, int gameNo, String nickName) {
		this.total = total;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
		this.gameNo = gameNo;
		this.nickName = nickName;
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

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Score [total=");
		builder.append(total);
		builder.append(", win=");
		builder.append(win);
		builder.append(", lose=");
		builder.append(lose);
		builder.append(", gameNo=");
		builder.append(gameNo);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append("]");
		return builder.toString();
	}
	
}
