package com.database.dao;

import java.util.List;

import com.database.common.ResCode;
import com.database.model.Notice;
import com.database.util.CustomException;

public class NoticeDao extends BaseDao{

	final String MAPPER_NS = Notice.class.getName();

	public NoticeDao() {
	}

	//---여정--------------------------------------//



	//---성은--------------------------------------//
	public Notice select(Integer no) throws CustomException {
		Notice notice = null;
		
		try {
			notice = session.selectOne(MAPPER_NS + ".select-notice", no);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
			/*throw new BoardException(e.getMessage());*/
		}
		return notice;
	}
	
	public List<Notice> selectAll(Integer gameNo) throws CustomException {
		List<Notice> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-all-notice", gameNo);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());			
		}
		
		return list;
	}

	//---정욱--------------------------------------//
	public void insert(Notice notice) throws CustomException {
		try {
			session.insert(MAPPER_NS + ".insert-notice", notice);
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
	
	public void update(Notice notice) throws CustomException {
		try {
			session.update(MAPPER_NS+".update-notice", notice);
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
}
