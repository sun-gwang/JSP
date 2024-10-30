<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/* 문자 인코딩 */
	request.setCharacterEncoding("UTF-8");

	/* 데이터 수신 */
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String addr = request.getParameter("addr");
	String gender = request.getParameter("gender");
	String[] hobbies  = request.getParameterValues("hobby");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>resultPost</title>
	</head>
	<body>
		<h3>Post 요청 결과</h3>
		<p>
			아이디 : <%=uid %><br>
			이름 : <%=name %><br>
			생년월일 : <%=birth %><br>
			주소 : <%=addr %><br>
			성별 : <%=gender %><br>
			취미 : <%
				for(String hobby : hobbies){
				out.print(hobby+ ",");
			} %><br>
		</p>
		<a href="../1.request.jsp">뒤로가기</a>
	</body>
</html>