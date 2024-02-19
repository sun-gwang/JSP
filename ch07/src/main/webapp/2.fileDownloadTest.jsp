<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ch07.dto.FileDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	FileDTO fileDTO = null;
	List<FileDTO> files = new ArrayList<>();
	
	try{
		// 1단계 - JNDI 서비스 객체 생성
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
							
		// 2단계 - 커넥션풀 객체 생성 후 접속객체 가져오기
		DataSource ds = (DataSource) ctx.lookup("jdbc/studydb");
		Connection conn = ds.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM `filetest`");
		
		while(rs.next()){
			fileDTO = new FileDTO();
			fileDTO.setFno(rs.getInt(1));
			fileDTO.setTitle(rs.getString(2));
			fileDTO.setoName(rs.getString(3));
			fileDTO.setsName(rs.getString(4));
			fileDTO.setRdate(rs.getString(5));
			
			files.add(fileDTO);
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
		<title>2.파일 다운로드</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>원본파일명</th>
				<th>저장파일명</th>
				<th>날짜</th>
				<th>다운로드</th>
				<th>관리</th>
				
			</tr>
			<%for(FileDTO filedto : files){ %>
			<tr>
				<td><%=filedto.getFno() %></td>
				<td><%=filedto.getTitle() %></td>
				<td><%=filedto.getoName() %></td>
				<td><%=filedto.getsName() %></td>
				<td><%=filedto.getRdate().substring(2,10) %></td>
				<td>
					<a href = "proc/fileDownloadProc.jsp?fno=<%=filedto.getFno() %>">다운로드</a>
				</td>
				<td>
					<a href="proc/fileModify.jsp?fno=<%=filedto.getFno()%>">수정</a>
					<a href="proc/fileDelete.jsp?fno=<%=filedto.getFno()%>">삭제</a>
				</td>
			</tr>
			<%} %>
		</table>
	</body>
</html>