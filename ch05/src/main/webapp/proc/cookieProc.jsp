<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cookieProc</title>
	</head>
	<body>
		<h3>쿠키생성</h3>
		<%
			// 클라이언트에서 서버로 요청(request) -> 받기
			request.setCharacterEncoding("UTF-8");	
		
			String uid = request.getParameter("uid");	
			String pass = request.getParameter("pass");	
			
			// 쿠키 생성
			Cookie c1 = new Cookie("cid","uid");
			// 쿠키 생성 시간이 1분
			c1.setMaxAge(60 *1);
			
			Cookie c2 = new Cookie("cpw","pass");
			// 쿠키 생성 시간이 3분
			c2.setMaxAge(60 *3);
			
			// 서버에서 클라이언트로 쿠키 실어보냄 (response)
			response.addCookie(c1);
			response.addCookie(c2);
		%>
		
		<a href="./cookieResult.jsp">쿠키확인</a>
	</body>
</html>