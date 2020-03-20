<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="com.db.loginDB"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%
    // using signton pattern
   	request.setCharacterEncoding("UTF-8");
   	loginDB logindb = loginDB.getInstace();
   	
   	String input_ID, input_Password, result;
   	String login_data = request.getParameter("login_data");
   	
   	try{
  
   		JSONParser parser 		= new JSONParser();
   		Object object		 	= parser.parse(login_data);
   		JSONObject jsonObject 	= (JSONObject)object;
   		
   		System.out.println(jsonObject.toString());
   		
   		input_ID 		= jsonObject.get("id").toString();
   		input_Password 	= jsonObject.get("password").toString();
   		
   
   		System.out.println(input_ID);
   		System.out.println(input_Password);
           
        // result return user name
   		result = logindb.loginDB(input_ID, input_Password);
   		out.print(result);
   		
   	} catch(Exception e){
   		e.printStackTrace();
   	}
%>
