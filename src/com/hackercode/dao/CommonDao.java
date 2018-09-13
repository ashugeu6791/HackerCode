package com.hackercode.dao;

import com.hackercode.structures.Admin;




public interface CommonDao {
	
	public Boolean isUserExists(String email,String password);
	public String getUserType(int userId);
	public Admin getUser(String email);
	public boolean setLastLogin(Long id);
	public Long getUserId(String email);
	public Admin getUserById(int u_id);
	
}
