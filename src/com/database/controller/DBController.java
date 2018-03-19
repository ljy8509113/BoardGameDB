package com.database.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.database.dao.UserDao;
import com.database.model.User;
import com.database.util.CustomException;

public class DBController {
	private static DBController instance = null;

	public static DBController Instance() {
		if(instance == null) {
			instance = new DBController();
			instance.userDao = new UserDao(); 
		}

		return instance;
	}

	UserDao userDao = null;

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



	//---성은--------------------------------------//



	//---정욱--------------------------------------//
}
