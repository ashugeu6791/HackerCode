package com.hackercode.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.hackercode.structures.Admin;

public class AdminMapper implements RowMapper<Admin>{
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Admin admin = new Admin();
	      admin.setUserName(rs.getString("userName"));
	      admin.setPassword(rs.getString("password"));
	      return admin;
	   }
}