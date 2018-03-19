package com.database.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.database.dao.AdminDao;
import com.database.dao.AuthorityDao;
import com.database.dao.GameDao;
import com.database.dao.ScoreDao;
import com.database.dao.UserDao;
import com.database.model.Admin;
import com.database.model.Authority;
import com.database.model.Game;
import com.database.model.Score;
import com.database.model.User;
import com.database.util.AdminException;
import com.database.util.CustomException;

public class DBController {
	private static DBController instance = null;

	public static DBController Instance() {
		if(instance == null) {
			instance = new DBController();
			instance.userDao = new UserDao(); 
			instance.scoreDao = new ScoreDao();
			instance.adminDao = new AdminDao();
			instance.authorityDao = new AuthorityDao();
			instance.gameDao = new GameDao();
		}

		return instance;
	}

	UserDao userDao = null;
	ScoreDao scoreDao = null;
	GameDao gameDao = null;
	AdminDao adminDao = null;
	AuthorityDao authorityDao = null;
	
	public User login(String email, String password) throws InvalidKeyException, ClassNotFoundException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, CustomException, SQLException{
		return userDao.selectUser(email, password);
	}

	public User selectUser(String email) throws ClassNotFoundException, SQLException, CustomException {
		return userDao.selectUser(email);
	}

	public void join(User user) throws InvalidKeyException, ClassNotFoundException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, CustomException, SQLException {
		userDao.insert(user);
	}




	//---여정--------------------------------------//
	public Admin selectAdmin(String id) throws AdminException {
		return adminDao.selectAdmin(id);
	}
	
	public Authority selectAuthority(Integer id) {
		return authorityDao.selectAuthority(id);
	}


	//---성은--------------------------------------//
	public List<Game> selectAllGame(String game_no) {
		return gameDao.selectAll();
	}


	//---정욱--------------------------------------//
	public Score selectScore(String email, int gameNo) throws CustomException {
		return scoreDao.select(email, gameNo);
	}
}
