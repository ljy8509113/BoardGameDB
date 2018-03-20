package com.database.dao;

import java.util.List;

import com.database.common.ResCode;
import com.database.model.Game;
import com.database.util.CustomException;

public class GameDao extends BaseDao {
	final String MAPPER_NS = Game.class.getName();
	
	public GameDao() {		
	}
	
	public Game select(Integer gameNo) throws CustomException {
		Game game = null;
		
		try {
			game = session.selectOne(MAPPER_NS + ".select-game", gameNo);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*throw new BoardException(e.getMessage());*/
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
		
		return game;
	}

	public List<Game> selectAll() throws CustomException {
		List<Game> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-all-game");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*throw new BoardException(e.getMessage());*/
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
		
		return list;
	}
	
	public void insert(Game game) throws CustomException {
		try {
			session.insert(MAPPER_NS + ".insert-game", game);
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
	
	public void update(Game game) throws CustomException{
		try {
			session.update(MAPPER_NS +".update-game", game);
		}catch(Exception e) {
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
}
