<%@page import="com.google.gson.Gson"%>
<%@page import="java.awt.Polygon"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.User2DTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	
	User2DTO dto = null;
	List<User2DTO> user2 = new ArrayList<>();
	try{
		
		// 1단계 JNDI 서비스 객체 생성 
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");		
		
		// 2단계 커넥션풀 객체 생성 
		DataSource ds = (DataSource) ctx.lookup("jdbc/studydb");
		Connection conn = ds.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM `user2`");
		
		while(rs.next()){
			
			dto = new User2DTO();
			dto.setUid(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setBirth(rs.getString(3));
			dto.setAddr(rs.getString(4));
			
			user2.add(dto);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	// Json 출력
	Gson gson = new Gson();
	String strJson = gson.toJson(user2);
	out.print(strJson);
	
%>

