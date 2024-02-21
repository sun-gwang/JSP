<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//String success = request.getParameter("success");
	String sessUid = (String) session.getAttribute("sessUid");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>3.ListenerTest</title>
		<%--
			날짜 : 2024/02/21
			이름 : 김선광
			내용 : 리스너 실습하기
		 --%>
	</head>
	<body>
		<h3>3.Listener</h3>
		<form action="/ch09/login.do" method="post">
			
			<%if(sessUid == null){ %>
			<input type="text" name="uid"><br>
			<input type="password" name="pass"><br>
			<input type="submit" value="로그인"><br>
			<%}else{ %>
				<p>
					<%=sessUid %>님 반갑습니다.
				</p>
				<a href="/ch09/logout.do">로그아웃</a>
			<%} %>
		</form>	
		
	</body>
</html>