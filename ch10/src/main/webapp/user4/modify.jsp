<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::modify</title>
	</head>
	<body>
		<h3>user4::수정</h3>
		<a href="/ch10/index.jsp">처음으로</a>
		<a href="/ch10/user4/list.do">목록보기</a>
		<form action="/ch10/user4/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" readonly value="${user.uid}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user.name}"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<select name="gender" >
							<option  value="M">M</option>
							<option  value="F"> F</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user.age}"></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${user.hp}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${user. addr}"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
					<input type="submit" value="수정하기" >
					</td>
				</tr>
			</table>
			</form>
	</body>
</html>