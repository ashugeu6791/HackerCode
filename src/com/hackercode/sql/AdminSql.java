package com.hackercode.sql;

public interface AdminSql {
	public static final String GET_ADMIN = "SELECT CASE WHEN EXISTS ("+
		    "SELECT password from users where userName=?) THEN 'True' ELSE 'False' END";
	
	public static final String FIND_USER_EXIST = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE userName=?) THEN 'True' ELSE 'False' END";
	
	public static final String GET_USER_TYPE = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE userName=? and password=?) THEN 'True' ELSE 'False' END";
	
	public static final String GET_USER_ID = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE userName=? and password=?) THEN 'True' ELSE 'False' END";
	
	public static final String GET_USER = "SELECT CASE WHEN EXISTS ("+
			"SELECT password FROM users WHERE userName=? and password=?) THEN 'True' ELSE 'False' END";
	
	public static final String GET_USER_BY_ID = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE userName=? and password=?) THEN 'True' ELSE 'False' END";
	
	public static final String UPADTE_LAST_LOGIN = "SELECT CASE WHEN EXISTS ("+
			"SELECT * FROM users WHERE userName=? and password=?) THEN 'True' ELSE 'False' END";

	public static final String REGISTER_NEW_USER ="INSERT INTO users (userName, password, userType) values(?,?,?)";
	
}
