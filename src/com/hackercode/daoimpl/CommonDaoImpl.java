package com.hackercode.daoimpl;


import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hackercode.dao.CommonDao;
import com.hackercode.mappers.AdminMapper;
import com.hackercode.sql.AdminSql;
import com.hackercode.structures.Admin;



public class CommonDaoImpl implements CommonDao{
		
	static Logger log = Logger.getLogger(CommonDao.class.getName());
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	}
	

	@Override
	public Boolean isUserExists(String email) {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(dataSource);
		Object [] params = new Object [] {email};
		int [] types = new int [] {Types.VARCHAR} ;
		//User user=null;
		Boolean user=false;
		try
		{
			user = (Boolean)jdbcTemplate.queryForObject(AdminSql.FIND_USER_EXIST, params, types, Boolean.class);
		}catch(Exception e)
		{
			log.error("CommonDaoImpl.isUserExists method DB Exception "+e);
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	@Override
	public String getUserType(int userId) {
		// TODO Auto-generated method stub
		String userType = null;
		Object [] params = new Object [] {userId};
		int [] types = new int [] {Types.NUMERIC} ;
		try
		{
			userType = jdbcTemplate.queryForObject(AdminSql.GET_USER_TYPE,params,types,String.class);
		}
		catch(Exception e)
		{
			System.out.println("Error happened in getting contactEmail for user id="+userId+"   "+e);
		}
	
		return userType;
	}

	@Override
	public Long getUserId(String email) {
		// TODO Auto-generated method stub
		Long userId = null;
		Object [] params = new Object [] {email};
		int [] types = new int [] {Types.VARCHAR} ;
		try
		{
			userId = jdbcTemplate.queryForObject(AdminSql.GET_USER_ID,params,types,Long.class);
		}
		catch(Exception e)
		{
			System.out.println("Error happened in getting User ID for user name="+email+"   "+e);
		}
	
		return userId;
	}

	@Override
	public Admin getUser(String email, String password) {
		// TODO Auto-generated method stub
		Object [] params = new Object [] {email, password};
		int [] types = new int [] {Types.VARCHAR,Types.VARCHAR};
		
		Admin user=null;
		try
		{
			user = jdbcTemplate.queryForObject(AdminSql.GET_USER, params, types, new AdminMapper());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	public boolean setLastLogin(Long id) {
		// TODO Auto-generated method stub
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		Object [] params = new Object [] {timestamp,id};
		int [] types = new int [] {Types.VARCHAR,Types.NUMERIC};
		
		try
		{
			jdbcTemplate.update(AdminSql.UPADTE_LAST_LOGIN,params,types);
			return true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Admin getUserById(int u_id) {
		// TODO Auto-generated method stub
		Object [] params = new Object [] {u_id};
		int [] types = new int [] {Types.NUMERIC};
		
		Admin user=null;
		try
		{
			user = (Admin)jdbcTemplate.queryForObject(AdminSql.GET_USER_BY_ID, params, types, new AdminMapper());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return user;
	}


	@Override
	public boolean registerNewUser(String email, String username, String password) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(dataSource);
		Object [] params = new Object [] {username, password, "Student"};		
		int [] types = new int [] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR} ;
		//User user=null;
		Boolean user=false;
		try{
			jdbcTemplate.update(AdminSql.REGISTER_NEW_USER, params, types);
		}catch(Exception e){
			log.error("CommonDaoImpl.registerNewUser method error DB Exception "+e);
			System.out.println(e.getMessage());
		}
		return false;
	}


}