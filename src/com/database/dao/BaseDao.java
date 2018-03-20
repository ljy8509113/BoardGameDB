package com.database.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public abstract class BaseDao {
	
	protected static ApplicationContext context = null;
	protected static SqlSession session = null;
	
	public BaseDao() {
		if(context == null) {
			context = new GenericXmlApplicationContext("/com/database/config/applicationContext.xml");
			session =  context.getBean(SqlSession.class);
			System.out.println("basedao null");
		}else {
			System.out.println("basedao null 아님");
		}
	}
}
