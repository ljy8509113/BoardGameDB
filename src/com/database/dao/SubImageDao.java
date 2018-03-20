package com.database.dao;

import java.util.HashMap;
import java.util.List;

import com.database.common.ResCode;
import com.database.model.SubImage;
import com.database.util.CustomException;

public class SubImageDao extends BaseDao {
	final String MAPPER_NS = SubImage.class.getName();
	
	public SubImageDao() {			
	}
	
	public List<SubImage> select(Integer gameNo) throws CustomException {
		List<SubImage> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-subimage", gameNo);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());			
		}
		
		return list;
	}
	
	public void insert(SubImage subImage) throws CustomException {
		try {
			session.insert(MAPPER_NS + ".insert-subimage", subImage);
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
	
	public void update(SubImage subImage) throws CustomException {
		try {
			session.update(MAPPER_NS+".update-subimage", subImage);
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
	
	public void delete(int gameNo, int no) throws CustomException {
		try {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("gameNo", gameNo);
			map.put("no", no);
			session.delete(MAPPER_NS+".delete-subimage", map);
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomException(ResCode.ERROR_DB.getResCode(), ResCode.ERROR_DB.getMessage());
		}
	}
}
