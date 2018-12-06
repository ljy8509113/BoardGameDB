package com.database.dao;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.database.common.ResCode;
import com.database.model.User;
import com.database.util.CustomException;

public class UserDao extends BaseDao{
	
	final String MAPPER_NS = User.class.getName();
	
	public UserDao() {		
	}
	
	public void insert(User user) throws CustomException, ClassNotFoundException, SQLException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		int count = session.selectOne(MAPPER_NS + ".select-email", user.getEmail());
		
		if(count > 0)
			throw new CustomException(ResCode.ERROR_EMAIL_OVERLAP.getResCode(), ResCode.ERROR_EMAIL_OVERLAP.getMessage());
		
		count = session.selectOne(MAPPER_NS + ".select-nickName", user.getNickname()); 
		
		if(count > 0)
			throw new CustomException(ResCode.ERROR_NICKNAME_OVERLAP.getResCode(), ResCode.ERROR_NICKNAME_OVERLAP.getMessage());
		
		session.insert(MAPPER_NS + ".insert-user", user);
		
	}
	
	//유저찾기
	public User selectUser(String email) throws ClassNotFoundException, SQLException, CustomException {
		User user = null;
		try {
			user = session.selectOne(MAPPER_NS + ".select-user", email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
		
		return user;
	}

	//로그인
	public User loginUser(String email) throws CustomException, SQLException, ClassNotFoundException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		User user = session.selectOne(MAPPER_NS + ".select-user", email);
		if(user == null) {
			throw new CustomException(ResCode.ERROR_EMAIL_NOT_FOUND.getResCode(), ResCode.ERROR_EMAIL_NOT_FOUND.getMessage());			
		}else {
			return user;			
		}			
	}
	
	public int updatePoint(String email, int addPoint) throws ClassNotFoundException, SQLException, CustomException {
		User user = session.selectOne(MAPPER_NS + ".select-user", email);
		if(user == null) {
			throw new CustomException(ResCode.ERROR_EMAIL_NOT_FOUND.getResCode(), ResCode.ERROR_EMAIL_NOT_FOUND.getMessage());			
		}else {
			user.updatePoint(addPoint);
			session.update(MAPPER_NS + ".update-point", user);
			return user.getPoint();
		}
	}
}
