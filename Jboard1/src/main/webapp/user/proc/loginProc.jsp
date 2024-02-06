<%@page import="kr.co.jboard1.dao.UserDAO"%>
<%@page import="com.mysql.cj.jdbc.ha.BestResponseTimeBalanceStrategy"%>
<%@page import="kr.co.jboard1.dto.UserDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.db.SQL"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	//전송할 두 가지
	String uid = request.getParameter("uid");
	String pass = request.getParameter("pass");
	
	UserDTO user = UserDAO.getInstance().selectUserForLogin(uid, pass);

	// 회원 여부에 따라서 세션 처리
	if(user != null){
		// 회원이 맞을 경우
		// 회원 객체 세션 저장
		session.setAttribute("sessUser", user);
		
		// 글 목록으로 이동
		response.sendRedirect("/Jboard1/list.jsp");
	}else{
		// 회원이 아닐 경우 -> 로그인 이동
		response.sendRedirect("/Jboard1/user/login.jsp?code=100");
	}
	
%>