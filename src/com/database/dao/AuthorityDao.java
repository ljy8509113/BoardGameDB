package com.database.dao;

import com.database.model.Authority;

public class AuthorityDao extends BaseDao {

	private static final String MAPPER_NS = Authority.class.getName();
	
//	@Autowired
//	private SqlSession session;
	
	public AuthorityDao() {}
	
	public Authority selectAuthority(Integer id) {
		
		Authority authority = null;
		
		authority = session.selectOne(MAPPER_NS + ".select-authority");
		
		return authority;
	}
	
}
