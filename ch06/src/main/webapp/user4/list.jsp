<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dto.User4DTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "kc5353";
	String pass = "abcd1234";
	
	User4DTO dto = null;
	List<User4DTO> users = new ArrayList<>();
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM `User4`");
		
		while(rs.next()){
			dto = new User4DTO();
			dto.setUid(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setGender(rs.getString(3));
			dto.setAge(rs.getString(4));
			dto.setHp(rs.getString(5));
			dto.setAddr(rs.getString(6));
			
			users.add(dto);
			
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user4::list</title>
	</head>
		<body>
			<h3>User4 목록</h3>
			<a href="../1.Jdbc.jsp">처음으로</a>
			<a href="./register.jsp">등록하기</a>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>나이</th>
					<th>휴대폰</th>
					<th>주소</th>
					<th>관리</th>
				</tr>
				<%for(User4DTO user4 : users){ %>
				<tr>
					<td><%=user4.getUid()%></td>
					<td><%=user4.getName()%></td>
					<td><%=user4.getGender()%></td>
					<td><%=user4.getAge()%></td>
					<td><%=user4.getHp()%></td>
					<td><%=user4.getAddr()%></td>
					<td>
					<a href="./modify.jsp?uid=<%=user4.getUid()%>">수정</a>
					<a href="./delete.jsp?uid=<%=user4.getUid()%>">삭제</a>
					</td>
				</tr>
				<%} %>
			</table>
		</body>
</html>