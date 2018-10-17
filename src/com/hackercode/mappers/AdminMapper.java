package com.hackercode.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.hackercode.structures.User;

public class AdminMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	      User admin = new User();
	      admin.setU_id(rs.getInt("u_id"));
	      admin.setUsername(rs.getString("username"));
	      admin.setPassword(rs.getString("password"));
	      admin.setUserType(rs.getString("usertype"));
	      return admin;
	   }
}