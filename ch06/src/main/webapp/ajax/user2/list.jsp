<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax::user2</title>
		
		<script>
			window.onload = function(){
				
				// 문서객체 만들기
				const table = document.getElementsByTagName('table')[0];
				fetch('./proc/getUser2list.jsp')
				.then(response => response.json())
				.then((data)=>{
					
					for(const user of data){
						console.log(user);
						
						const tr = document.createElement('tr');
						
						const td1 = document.createElement('td');
						const td2 = document.createElement('td');
						const td3 = document.createElement('td');
						const td4 = document.createElement('td');
						const td5 = document.createElement('td');
						
						const a1 = document.createElement('a');
						const a2 = document.createElement('a');
						a1.href = './modify.jsp?uid='+user.uid;
						a1.innerText = '수정';
						a2.href = './delete.jsp?uid='+user.uid;
						a1.innerText = '삭제';
						td1.innerText = user.uid;
						td2.innerText = user.name;
						td3.innerText = user.birth;
						td4.innerText = user.addr;
					}
				})
				.catch()
			}
		
		</script>
		
		
		
	</head>
	
	<body>
		<h3>user2 목록</h3>
		<a href="./register.jsp">등록하기</a>
		<table border="1" id="list">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			
		</table>
	</body>
</html>