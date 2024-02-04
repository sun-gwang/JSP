<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dto.User5DTO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "kc5353";
	String pass = "abcd1234";
	
	User5DTO dto = null;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		PreparedStatement psmt = conn.prepareStatement("SELET * FROM `User5` WHERE `seq`=?");
		psmt.setString(1, seq);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			dto = new User5DTO();
			dto.setSeq(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setGender(rs.getString(3));
			dto.setAge(rs.getString(4));
			dto.setAddr(rs.getString(5));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User5::modify</title>
	</head>
		<body>
			<h3>User5 수정하기</h3>
			<a href="../1.Jdbc.jsp">처음으로</a>
			<a href="./list.jsp">목록보기</a>
			<form action="./modifyProc.jsp" method="post">
				<table border="1">
					<tr>
						<td>번호</td>
						<td><input type="text" name="seq" readonly ></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" ></td>
					</tr>
					<tr>
						<td>성별</td>
						<td><input type="text" name="gender" ></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type="text" name="age" ></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="addr" ></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
						<input type="submit" value="수정하기">
						</td>
					</tr>
				</table>
			</form>
		</body>
</html>