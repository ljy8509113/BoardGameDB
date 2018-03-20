package com.database.test;

import com.database.controller.DBController;
import com.database.model.Game;
import com.database.model.User;
import com.database.util.CustomException;
import com.security.Security;

public class Test {
	public static void main(String[] args) {
//		try {
//			User user = DBController.Instance().selectUser("test@gmail.com");
//			System.out.println("user : " + user.getEmail());
//			
//			//User user1 = new User("test1@gmail.com", "1234", "test1", new Date());
//			DBController.Instance().login("test1@gmail.com", Security.Instance().cryption("1234", true));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		
//		Game game = new Game(null, "게임설명", "게임제목테스트", "c:\test\test.jpg", "D", null, "0.0.1");
//		try {
//			DBController.Instance().insertGame(game);
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Game game = DBController.Instance().selectGameDetail(1);
//		game.setTitle("title");
//		try {
//			DBController.Instance().updateGame(game);
//			System.out.println("끗");
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
