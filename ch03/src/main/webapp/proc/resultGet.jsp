<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>resultGet</title>
	</head>
	<body>
		<h3>Get 요청결과</h3>
		<%
			
			request.setCharacterEncoding("UTF-8");
		
		 	String uid  = request.getParameter("uid"); // name 값이 들어온다
			String name = request.getParameter("name");
			String age  = request.getParameter("age");
		%>
		
		<p>아이디: <%=uid %></p>
		<p>이름:  <%=name %></p>
		<p>나이:  <%=age %></p>
		
		<a href="../1.request.jsp">뒤로가기</a>
		
	</body>
</html>