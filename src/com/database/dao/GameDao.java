package com.database.dao;

import java.util.List;

import com.database.model.Game;

public class GameDao extends BaseDao {
	final String MAPPER_NS = Game.class.getName();
	
	public GameDao() {
		
	}
	
	public Game select(String game_no) {
		Game game = null;
		
		try {
			game = session.selectOne(MAPPER_NS + ".select-game", game_no);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*throw new BoardException(e.getMessage());*/
		}
		
		return game;
	}

	public List<Game> selectAll() {
		List<Game> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-all-game");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*throw new BoardException(e.getMessage());*/
		}
		
		return list;
	}
}
