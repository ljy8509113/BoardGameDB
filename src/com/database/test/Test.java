package com.database.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.database.controller.DBController;
import com.database.model.User;
import com.database.util.CustomException;
import com.security.Security;

public class Test {
	public static void main(String[] args) {
		try {
			User user = DBController.Instance().selectUser("test@gmail.com");
			System.out.println("user : " + user.getEmail());
			
			//User user1 = new User("test1@gmail.com", "1234", "test1", new Date());
			DBController.Instance().login("test1@gmail.com", Security.Instance().cryption("1234", true));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
