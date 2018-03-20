package com.database.dao;

import java.util.List;

import com.database.model.Notice;

public class NoticeDao extends BaseDao{

	final String MAPPER_NS = Notice.class.getName();

	public NoticeDao() {

	}

	//---여정--------------------------------------//


	//---성은--------------------------------------//
	public Notice select(Integer no) {
		Notice notice = null;
		
		try {
			notice = session.selectOne(MAPPER_NS + ".select-notice", no);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*throw new BoardException(e.getMessage());*/
		}
		return notice;
	}
	
	public List<Notice> selectAll(Integer gameNo) {
		List<Notice> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-all-notice", gameNo);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*throw new BoardException(e.getMessage());*/
		}
		
		return list;
	}

	//---정욱--------------------------------------//
}
