<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="shop.dto.CustomerDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="org.apache.catalina.realm.DataSourceRealm"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String custid = request.getParameter("custId");

	CustomerDTO dto = null;
	List<CustomerDTO> users = new ArrayList<>();
	
	try{
		Context initCtx = new InitialContext();
		Context ctx = (Context) initCtx.lookup("java:comp/env");
		
		DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
		Connection conn = ds.getConnection();
		
	
		PreparedStatement psmt = conn.prepareStatement("SELECT * FROM `customer` WHERE `custid`=?");
		
		psmt.setString(1, custid);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			dto = new CustomerDTO();
			dto.setCustId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setHp(rs.getString(3));
			dto.setAddr(rs.getString(4));
			dto.setRdate(rs.getString(5));
			
		}
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>customer::modify</title>
	</head>
	<body>
		<a href="../../2.DBCP.jsp">처음으로</a>
		<a href="./list.jsp">목록보기</a>
		<form action="./modifyProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name = "custId" readonly value="<%=dto.getCustId()%>"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name = "name" value="<%=dto.getName()%>"></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name = "hp" value="<%=dto.getHp()%>"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name = "addr" value="<%=dto.getAddr()%>"></td>
				</tr>
				<tr>
					<td>생성일</td>
					<td><input type="date" name = "rdate" value="<%=dto.getRdate()%>"></td>
				</tr>
			</table>
		</form>
	</body>
</html>