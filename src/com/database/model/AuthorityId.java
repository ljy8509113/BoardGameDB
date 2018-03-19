package com.database.model;

public enum AuthorityId {
	
	ADMIN(10);
	
	private Integer id;

	private AuthorityId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}


}
