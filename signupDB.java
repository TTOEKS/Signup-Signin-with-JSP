package com.db;
import java.sql.*;
import org.json.simple.JSONObject;;

public class signupDB {

	// using singleton pattern
	private static signupDB instance = new signupDB();

	public static signupDB getInstance() {
		return instance;
	}
	
	static String jdbcurl 		= "jdbc:mariadb://127.0.0.1:3306/news_collector";
	static String dbId	 	= "DB_id";
	static String dbPw		= "DB_password";
	
	
	public String signupDB(String name, String id, String password, String email) {
		Connection			conn		= null;
		PreparedStatement		pstmt		= null;
		ResultSet			rs		= null;
		String 				query 		= "";
		String 				returns 	= "";
		int 				num_update	= 0;
		
		
		// input name, id, password, e-mail
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn  = DriverManager.getConnection(jdbcurl, dbId, dbPw);
			
			query = "INSERT INTO USERS(NAME, ID, PASSWORD, EMAIL) VALUES(?,?,?,?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, email);

			
			num_update = pstmt.executeUpdate();
			System.out.println(num_update);
			if(num_update == 1) {
				returns = "true";
			}else {
				returns = "false";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return returns;
	
	}
}
