<%@page import="kr.co.jboard1.dto.UserDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 사용자 세션 열기
	UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");
	
	// 로그인을 하지 않았을 경우 
	if(sessUser==null){
		response.sendRedirect("/Jboard1/user/login.jsp?code=102");
		// 리턴 해줘야 밑으로 코드가 진행 안됨
		return;
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글목록</title>
    <link rel="stylesheet" href="./css/style.css">    
</head>
<body>
    <div id="container">
        <header>
            <h3>Board System v1.0</h3>
            <p>
                <%=sessUser.getNick() %>님 반갑습니다.
                <a href="/Jboard1/user/logout.jsp" class="logout">[로그아웃]</a>
            </p>
        </header>