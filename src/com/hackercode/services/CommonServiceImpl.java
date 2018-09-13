package com.hackercode.services;

import com.hackercode.dao.CommonDao;
import com.hackercode.structures.Admin;

public class CommonServiceImpl {

	public static CommonDao commonDao;

	public static Boolean isUserExists(String email,String password){
		return commonDao.isUserExists(email, password);
	}
	
	public static String getUserType(int userId){
		return commonDao.getUserType(userId);
	}
	
	public static Admin getUser(String email){
		return commonDao.getUser(email);
	}
	
	public static boolean setLastLogin(Long id){
		return commonDao.setLastLogin(id);
	}
	
	public static Long getUserId(String email){
		return commonDao.getUserId(email);
	}
	
	public static void setCommonDao(CommonDao commonDao) {
		CommonServiceImpl.commonDao = commonDao;
	}

	public static Admin getUserById(int u_id) {
		// TODO Auto-generated method stub
		return commonDao.getUserById(u_id);
	}
	
}
