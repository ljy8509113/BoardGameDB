package com.database.common;

public class Common {
	public static final int NO_DATA								= -1;
	public static final int DIVINCHICODE_GAME_CODE 				= 1;
	
	public static final int CODE_SUCCESS 						= 0;
	public static final int CODE_ERROR_DB 						= 100;
	public static final int CODE_ERROR_FULL 					= 101;
	public static final int CODE_ERROR_CONNECTION_ROOM 			= 102;
	public static final int CODE_ERROR_DECRYPTION 				= 103;
	public static final int CODE_ERROR_EMAIL_OVERLAP 			= 200;
	public static final int CODE_ERROR_EMAIL_NOT_FOUND 			= 201;
	public static final int CODE_ERROR_PASSWORD_MISS 			= 202;
	public static final int CODE_ERROR_PASSWORD_FAIL_FULL 		= 203;
	public static final int CODE_ERROR_NICKNAME_OVERLAP 		= 204;
	public static final int CODE_ERROR_OTHER_ACCEPT				= 205;
	public static final int CODE_ERROR_ROOM_PASSWORD_FAIL		= 206;
	public static final int CODE_ERROR_NOT_USE_EMAIL			= 207;

	public static final int CODE_ERROR_SCORE_NOT_FOUND			= 301;
	public static final int CODE_ERROR_USER_SCORE_NOT_FOUND		= 302;
	public static final int CODE_ERROR_NOT_FOUND_ROOM			= 303;
	public static final int CODE_ERROR_DISCONNECT_USER			= 304;
	public static final int CODE_ERROR_NOT_READY				= 305;
	public static final int CODE_ERROR_NOT_ENOUGH				= 306;
	
	//다빈치코드
	public static final int CODE_ERROR_NUMBER_NOT_SELECT		= 401;
	public static final int CODE_ERROR_ADD_COMPUTER				= 402;
	
	public static final String AUTO_ID							= "auto_id_imsi_";
}
