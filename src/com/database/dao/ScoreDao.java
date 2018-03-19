package com.database.dao;

import java.util.HashMap;

import com.database.common.ResCode;
import com.database.model.Score;
import com.database.util.CustomException;

public class ScoreDao extends BaseDao{
	
	final String MAPPER_NS = Score.class.getName();
	
	public ScoreDao() {
		
	}
	
	public Score select(String email, int gameNo) throws CustomException {
		Score score;
		try {
			HashMap<String, String> map = new HashMap<>();
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
	
}
