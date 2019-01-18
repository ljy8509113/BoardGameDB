package com.database.common;

public enum ResCode {
	SUCCESS(Common.CODE_SUCCESS),
	ERROR_DB(Common.CODE_ERROR_DB),
	ERROR_FULL(Common.CODE_ERROR_FULL),
	ERROR_CONNECTION_ROOM(Common.CODE_ERROR_CONNECTION_ROOM),
	ERROR_DECRYPTION(Common.CODE_ERROR_DECRYPTION),
	ERROR_EMAIL_OVERLAP(Common.CODE_ERROR_EMAIL_OVERLAP),
	ERROR_EMAIL_NOT_FOUND(Common.CODE_ERROR_EMAIL_NOT_FOUND),
	ERROR_PASSWORD_MISS(Common.CODE_ERROR_PASSWORD_MISS),
	ERROR_PASSWORD_FAIL_FULL(Common.CODE_ERROR_PASSWORD_FAIL_FULL),
	ERROR_NICKNAME_OVERLAP(Common.CODE_ERROR_NICKNAME_OVERLAP),
	ERROR_NOT_USE_EMAIL(Common.CODE_ERROR_NOT_USE_EMAIL),
	
	ERROR_USER_SCORE_NOT_FOUND(Common.CODE_ERROR_USER_SCORE_NOT_FOUND),
	ERROR_SCORE_NOT_FOUND(Common.CODE_ERROR_SCORE_NOT_FOUND),
	ERROR_NOT_FOUND_ROOM(Common.CODE_ERROR_NOT_FOUND_ROOM),
	ERROR_OTHER_ACCEPT(Common.CODE_ERROR_OTHER_ACCEPT),
	ERROR_ROOM_PASSWORD(Common.CODE_ERROR_ROOM_PASSWORD_FAIL),
	ERROR_DISCONNECT_USER(Common.CODE_ERROR_DISCONNECT_USER),
	ERROR_NOT_READY(Common.CODE_ERROR_NOT_READY),
	ERROR_NOT_ENOUGH(Common.CODE_ERROR_NOT_ENOUGH),
	//다빈치코드
	ERROR_NUMBER_NOT_SELECT(Common.CODE_ERROR_NUMBER_NOT_SELECT),
	ERROR_ADD_COMPUTER(Common.CODE_ERROR_ADD_COMPUTER);
	
	int resCode;
	String message;

	ResCode(int resCode){
		this.resCode = resCode;

		switch(resCode) {
		case Common.CODE_SUCCESS:
			message = "성공";
			break;
		case Common.CODE_ERROR_DB:
			message = "데이터를 조회 할 수 없습니다.\n잠시후 다시 시도해주세요.";
			break;
		case Common.CODE_ERROR_FULL:
		case Common.CODE_ERROR_CONNECTION_ROOM:
			message = "선택하신 방은 입장 불가능합니다.";
			break;
		case Common.CODE_ERROR_DECRYPTION:
			message = "로그인중 오류가 발생하였습니다.\n잠시 후 다시 시도해주세요.";
			break;
		case Common.CODE_ERROR_EMAIL_OVERLAP:
			message = "가입된 이메일이 존재합니다.";
			break;
		case Common.CODE_ERROR_EMAIL_NOT_FOUND :
			message = "사용자가 존재하지 않습니다.";
			break;
		case Common.CODE_ERROR_PASSWORD_MISS:
			message = "비밀번호가 일치하지 않습니다.";
			break;
		case Common.CODE_ERROR_PASSWORD_FAIL_FULL :
			message = "비밀번호를 10회 이상 잘못 입력되었습니다. 관리자에게 문의해주세요.";
			break;
		case Common.CODE_ERROR_NICKNAME_OVERLAP:
			message = "중복된 닉네임이 존재합니다.";
			break;
		case Common.CODE_ERROR_OTHER_ACCEPT :
			message = "다른 단말기에서 접속되었습니다.";
			break;
		case Common.CODE_ERROR_NOT_USE_EMAIL :
			message = "사용할 수 없는 이메일입니다.";
			break;
		case Common.CODE_ERROR_USER_SCORE_NOT_FOUND :
			message = "유저 스코어가 존재하지 않습니다.";
			break;
		case Common.CODE_ERROR_SCORE_NOT_FOUND :
			message = "스코어가 존재하지 않습니다.";
			break;
		case Common.CODE_ERROR_NOT_FOUND_ROOM:
			message = "게임방을 찾을 수 없습니다.";
			break;
		case Common.CODE_ERROR_NUMBER_NOT_SELECT :
			message = "해당번호는 선택할 수 없습니다.";
			break;
		case Common.CODE_ERROR_ROOM_PASSWORD_FAIL:
			message = "패스워드가 다릅니다.";
			break;
		case Common.CODE_ERROR_DISCONNECT_USER :
			message = "접속이 끊긴 유저가 존재합니다.";
			break;
		case Common.CODE_ERROR_NOT_READY:
			message = "준비되지 않은 유저가 존재합니다.";
			break;
		case Common.CODE_ERROR_NOT_ENOUGH :
			message = "인원이 충분하지 않습니다.";
			break;
		}
	}

	public int getResCode() {
		return resCode;
	}

	public String getMessage() {
		return message;
	}
}
