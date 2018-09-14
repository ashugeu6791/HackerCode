package com.hackercode.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.hackercode.structures.Admin;

public class AdminMapper implements RowMapper<Admin>{
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Admin admin = new Admin();
	      admin.setU_id(rs.getInt("u_id"));
	      admin.setUserName(rs.getString("username"));
	      admin.setPassword(rs.getString("password"));
	      admin.setUserType(rs.getString("usertype"));
	      return admin;
	   }
}