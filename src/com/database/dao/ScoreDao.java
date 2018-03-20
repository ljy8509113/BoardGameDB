package com.database.dao;

import java.util.HashMap;

import com.database.common.ResCode;
import com.database.model.Game;
import com.database.model.Score;
import com.database.util.CustomException;

public class ScoreDao extends BaseDao{
	
	private static ScoreDao instance = null;
	public static ScoreDao Instance() {
		if(instance == null)
			instance = new ScoreDao();
		return instance;
	}
	
	final String MAPPER_NS = Score.class.getName();
	
	public ScoreDao() {
		
	}
	
	public Score select(String email, int gameNo) throws CustomException {
		Score score;
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("email", email);
			map.put("game_no",""+gameNo);
			score = session.selectOne(MAPPER_NS+".select", map);
			
			if(score == null || score.getEmail() == null || score.getEmail().equals("")) {
				score = new Score(email, 0, 0, 0, 0, gameNo);
			}
			
		}catch(Exception e) {
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
		
		return score;
	}
	
	public void insert(Score score) throws CustomException {
		try {
			session.insert(MAPPER_NS + ".insert-score", score);
		}catch(Exception e) {
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
	
	public void update(Score score) throws CustomException{
		try {
			session.update(MAPPER_NS +".update-score", score);
		}catch(Exception e) {
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
	
}
