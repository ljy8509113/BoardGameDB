package com.database.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.database.model.Admin;

public class AdminDao extends BaseDao {

	private final String MAPPER_NS = Admin.class.getName();

	public AdminDao() {
	}

	// 관리자 찾기, 권한 가져오기
	public Admin selectAdmin(String id){
		Admin admin = null;

		admin = session.selectOne(MAPPER_NS + ".select-admin", id);

		return admin;
	}

	// 관리자에 권한 부여
	public void insertAuthority(Admin admin) {
		session.insert(MAPPER_NS + "insert-authority", admin); 
	}





	/*// 로그인
	public Admin selectAdmin(String id, String password) throws CustomException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Admin admin = session.selectOne(MAPPER_NS + ".select-admin", id);

		if(admin == null) {
			throw new CustomException(ResCode.ERROR_EMAIL_NOT_FOUND.getResCode(), ResCode.ERROR_EMAIL_NOT_FOUND.getMessage());			
		} else if(admin.getFailCount() >= 10) {
			throw new CustomException(ResCode.ERROR_PASSWORD_FAIL_FULL.getResCode(), ResCode.ERROR_PASSWORD_FAIL_FULL.getMessage());
		} else {
			Map<String, String> map = new HashMap<String, String>();
			if(password.equals(Security.Instance().deCryption(admin.getPassword(), true))) {
				map.put("count", "0");
				map.put("email", admin.getId());
				session.update(MAPPER_NS + ".update-fail-count", map);

				String pw = Security.Instance().deCryption(admin.getPassword(), true);
				admin.setPassword(Security.Instance().cryption(pw, false));
				return admin;
			}else {
				map.put("count", admin.getFailCount()+1+"");
				map.put("email", admin.getId());
				session.update(MAPPER_NS + ".update-fail-count", map);
				throw new CustomException(ResCode.ERROR_PASSWORD_MISS.getResCode(), ResCode.ERROR_PASSWORD_MISS.getMessage());
			}
		}
	}*/

}


















