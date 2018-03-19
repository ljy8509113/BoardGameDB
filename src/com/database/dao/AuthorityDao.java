package com.database.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.database.model.Authority;

@Repository
public class AuthorityDao {

	private static final String MAPPER_NS = Authority.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public AuthorityDao() {}
	
	public Authority select(Integer id) {
		
		Authority authority = null;
		
		authority = session.selectOne(MAPPER_NS + ".select-authority");
		
		return authority;
	}
	
}
