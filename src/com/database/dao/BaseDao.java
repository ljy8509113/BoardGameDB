package com.database.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public abstract class BaseDao {
	
	protected ApplicationContext context;
	protected SqlSession session;
	
	public BaseDao() {
		context = new GenericXmlApplicationContext("/com/database/config/applicationContext.xml");
		session =  context.getBean(SqlSession.class);
	}
}
