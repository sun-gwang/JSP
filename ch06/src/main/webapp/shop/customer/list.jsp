<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::list</title>
	</head>
	<body>
		<h3>Customer 목록</h3>
		<a href="../../2.DBCP.jsp">처음으로</a>
		<a href="./register.jsp">입력하기</a>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>등록일</th>
				<th>관리</th>
			</tr>
			<tr>
				<td>a101</td>
				<td>홍길동</td>
				<td>010-1234-1000</td>
				<td>부산</td>
				<td>2024-02-02</td>
				<td>
					<a href="./modify.jsp">수정</a>
					<a href="./modify.jsp">삭제</a>
				<td>
			</tr>
		</table>
	</body>
</html>