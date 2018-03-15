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
		} catch (ClassNotFoundException | SQLException | CustomException e) {
			e.printStackTrace();
		} 
		catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
