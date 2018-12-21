package com.database.dao;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

import com.database.common.Common;
import com.database.common.ResCode;
import com.database.model.User;
import com.database.util.CustomException;
import com.security.Security;

public class UserDao extends BaseDao{
	
	final String MAPPER_NS = User.class.getName();
	
	public UserDao() {		
	}
	
	public void insert(User user, String password) throws CustomException, ClassNotFoundException, SQLException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		int count = session.selectOne(MAPPER_NS + ".select-email", user.getEmail());
		
		if(count > 0)
			throw new CustomException(ResCode.ERROR_EMAIL_OVERLAP.getResCode(), ResCode.ERROR_EMAIL_OVERLAP.getMessage());
		
		count = session.selectOne(MAPPER_NS + ".select-nickName", user.getNickname()); 
		
		if(count > 0)
			throw new CustomException(ResCode.ERROR_NICKNAME_OVERLAP.getResCode(), ResCode.ERROR_NICKNAME_OVERLAP.getMessage());
		
		String enc = Security.Instance().encrypt(password, true);
		user.setPassword(enc);
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
	public User loginUser(String email, String password) throws CustomException, SQLException, ClassNotFoundException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		User user = session.selectOne(MAPPER_NS + ".select-user", email);
		
		if(user == null) {
			throw new CustomException(ResCode.ERROR_EMAIL_NOT_FOUND.getResCode(), ResCode.ERROR_EMAIL_NOT_FOUND.getMessage());			
		}else if(user.getFailCount() >= 10) {
			throw new CustomException(ResCode.ERROR_PASSWORD_FAIL_FULL.getResCode(), ResCode.ERROR_PASSWORD_FAIL_FULL.getMessage());
		}else {
			
			Map<String, String> map = new HashMap<String, String>();
			String basePw = user.getPassword().trim().replace("\n", "");
			basePw.replace("\r", "");
			byte[] decodedBytes = Base64.decodeBase64(basePw);
			String pw = new String(decodedBytes);
			String dec = Security.Instance().decrypt(pw, true);
			if(password.equals(dec)) {
				map.put("count", "0");
				map.put("email", user.getEmail());
				session.update(MAPPER_NS + ".update-success-login", map);
				
//				String pw = Security.Instance().decrypt(user.getPassword(), true);
//				user.setPassword(Security.Instance().encrypt(pw, false));
				user.setPassword("");
				return user;
			}else {
				map.put("count", user.getFailCount()+1+"");
				map.put("email", user.getEmail());
				session.update(MAPPER_NS + ".update-fail-count", map);
				throw new CustomException(ResCode.ERROR_PASSWORD_MISS.getResCode(), ResCode.ERROR_PASSWORD_MISS.getMessage());
			}			
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
	
	public int getAutoIdCount() {
		String email = Common.AUTO_ID + "%";
		int count = session.selectOne(MAPPER_NS + ".select-auto-user", email);
		
		return count;
	}
}
