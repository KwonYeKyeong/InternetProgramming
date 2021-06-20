<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 페이지</title>
</head>
<body>
	<h2 align="center">관리자 로그인</h2>
	<form action="AdminController" method="POST">
		<table align="center">
			<tr>
				<td>아이디(ID) : </td>
				<td>
					<input type="text" name="id"/>
				</td>
			</tr>
			<tr>
				<td>비밀번호(PW) : </td>
				<td>
					<input type="password" name="pwd"/>
				</td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="로그인">
			<input type="button" value="돌아가기" onclick="location.href='main.jsp'">
		</p>	
	</form>
</body>
</html>