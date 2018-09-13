package com.hackercode.sql;

public interface AdminSql {
	public static final String GET_ADMIN = "SELECT password from adminlogin where username=?";
	
	public static final String FIND_USER_EXIST = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE email=? and password=?) THEN 'True' ELSE 'False' END";
	
	public static final String GET_USER_TYPE = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE email=? and password=?) THEN 'True' ELSE 'False' END";
	public static final String GET_USER_ID = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE email=? and password=?) THEN 'True' ELSE 'False' END";
	public static final String GET_USER = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE email=? and password=?) THEN 'True' ELSE 'False' END";
	public static final String GET_USER_BY_ID = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE email=? and password=?) THEN 'True' ELSE 'False' END";
	public static final String UPADTE_LAST_LOGIN = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE email=? and password=?) THEN 'True' ELSE 'False' END";
	
}
