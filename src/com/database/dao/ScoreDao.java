package com.database.dao;

import java.util.HashMap;
import java.util.List;

import com.database.common.ResCode;
import com.database.model.Score;
import com.database.util.CustomException;

public class ScoreDao extends BaseDao{
	final String MAPPER_NS = Score.class.getName();
	
	public ScoreDao() {		
	}
	
	public List<Score> selectGameRank(int gameNo) throws CustomException {
		List<Score> list;
		try {
			list = session.selectList(MAPPER_NS+".select-total", gameNo);
			
			if(list == null || list.size() == 0) {
				throw new CustomException(ResCode.ERROR_SCORE_NOT_FOUND.getResCode(), ResCode.ERROR_SCORE_NOT_FOUND.getMessage());
			}
			
		}catch(Exception e) {
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
		
		return list;
	}
	
	public Score select(String email, int gameNo, String nickName) throws CustomException {
		
		Score score = null;
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("email", email);
			map.put("gameNo", gameNo);
			
			score = session.selectOne(MAPPER_NS+".select-user-score", map);
			
			if(score == null || score.getEmail() == null || score.getEmail().equals("")) {
				score = new Score(email, 0, 0, 0, 0, gameNo, 0, nickName);
//				throw new CustomException(ResCode.ERROR_USER_SCORE_NOT_FOUND.getResCode(), ResCode.ERROR_USER_SCORE_NOT_FOUND.getMessage());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
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
