package com.database.dao;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.database.common.ResCode;
import com.database.model.User;
import com.database.util.CustomException;
import com.security.Security;

public class UserDao {
	
	private ApplicationContext context;
	private SqlSession session;
	final String MAPPER_NS = User.class.getName();
	
	public UserDao() {
		context = new GenericXmlApplicationContext("/com/database/config/applicationContext.xml");		
		session = context.getBean(SqlSession.class);
	}
	
	public void insert(User user) throws CustomException, ClassNotFoundException, SQLException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		int count = session.selectOne(MAPPER_NS + ".select-email", user.getEmail());
		
		if(count > 0)
			throw new CustomException(ResCode.ERROR_EMAIL_OVERLAP.getResCode(), ResCode.ERROR_EMAIL_OVERLAP.getMessage());
		
		count = session.selectOne(MAPPER_NS + ".select-nickName", user.getNickname()); 
		
		if(count > 0)
			throw new CustomException(ResCode.ERROR_NICKNAME_OVERLAP.getResCode(), ResCode.ERROR_NICKNAME_OVERLAP.getMessage());
		
		String password = Security.Instance().cryption(user.getPassword(), true);
		user.setPassword(password);
		
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
	public User selectUser(String email, String password) throws CustomException, SQLException, ClassNotFoundException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		User user = session.selectOne(MAPPER_NS + ".select-user", email);
		
		if(user == null) {
			throw new CustomException(ResCode.ERROR_EMAIL_NOT_FOUND.getResCode(), ResCode.ERROR_EMAIL_NOT_FOUND.getMessage());			
		}else if(user.getFailCount() >= 10) {
			throw new CustomException(ResCode.ERROR_PASSWORD_FAIL_FULL.getResCode(), ResCode.ERROR_PASSWORD_FAIL_FULL.getMessage());
		}else {
			if(password.equals(Security.Instance().deCryption(user.getPassword(), true))) {
				session.update(MAPPER_NS + ".update-fail-count", new String[]{"0", user.getEmail()});
				
				String pw = Security.Instance().deCryption(user.getPassword(), true);
				user.setPassword(Security.Instance().cryption(pw, false));
				return user;
			}else {
				String count = user.getFailCount()+1+"";
				session.update(MAPPER_NS + ".update-fail-count", new String[] {count, user.getEmail()});
				throw new CustomException(ResCode.ERROR_PASSWORD_MISS.getResCode(), ResCode.ERROR_PASSWORD_MISS.getMessage());
			}
		}
			
	}
}
