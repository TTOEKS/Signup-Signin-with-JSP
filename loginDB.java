package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONObject;

public class loginDB {
	
	// using singleton pattern
	private static loginDB instace = new loginDB();
	
	public static loginDB getInstace() {
		return instace;
	}
	
	// using MariaDB
	static String jdbcurl 	= "jdbc:mariadb://127.0.0.1:3306/news_collector";
	static String dbId		= "DB_ID"; // you DB Id
	static String dbPw		= "DB_Password";
	
	public String loginDB(String insertID, String insertPassword) {
		Connection 			conn  		= null;
		PreparedStatement		pstmt 		= null;
		ResultSet			rs	  	= null;
		String				query 		= "";
		String 				name		= "";
	
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(jdbcurl, dbId, dbPw );
			
			query = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, insertID);
			pstmt.setString(2, insertPassword);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("NAME");
			}else {
				name = "Null";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
}
