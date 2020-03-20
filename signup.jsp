<%@page import="org.json.simple.parser.JSONParser"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.db.signupDB" %>
<%@ page import ="java.net.*" %>
<%@ page import="org.json.simple.JSONObject" %>


<%
	
	request.setCharacterEncoding("UTF-8");
	signupDB signupdb = signupDB.getInstance();

	
	String signup_data			= request.getParameter("signup_data");
	
	
	try{
	// Convert JSONObject to String 
	JSONParser parser = new JSONParser();
	Object object = parser.parse(signup_data);
	JSONObject jsonObject = (JSONObject) object;

	
	System.out.println(signup_data);
	
	
	
	String user_name			= jsonObject.get("name").toString();
	String user_id				= jsonObject.get("id").toString();
	String user_password		= jsonObject.get("password").toString();
	String user_email			= jsonObject.get("email").toString();

	System.out.println(user_name);
	System.out.println(user_id);
	System.out.println(user_password);
	System.out.println(user_email);
	
	signupdb.signupDB(user_name, user_id, user_password, user_email);
	out.print("Success");
	
	}catch(NullPointerException e){
		e.printStackTrace();
		System.out.println("NullPointer Excpetion!! Fail to receive data ");
		out.println("NullPointer Excpetion!! Fail to receive data ");	
	}catch(Exception e){
		System.out.println("Exception Occure!!");
		e.printStackTrace();
	}

	
%>