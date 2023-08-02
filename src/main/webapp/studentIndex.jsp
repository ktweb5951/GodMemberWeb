<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>학생 관리 프로그램</h1>
		<h2>로그인 페이지</h2>
		<fieldset>
			<legend>로그인 </legend>
			<form action ="/student/login.do" metho="post">
				아이디 : <input type="text" name="stduent-id"><br>
				비밀번호 : <input type="texet name="student-pw"><br>
				<div>
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
					<a href="student/enroll.jsp">학생 정보 등록</a>
				</div>
			</form>
		</fieldset>	
		
	</body>
</html>