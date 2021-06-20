<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/mainnav.css" rel="stylesheet"/>
<title>유저 로그인 페이지</title>
</head>
<body>
<h1 align="center">YK BookStore</h1>
	<nav>
		<ul id="menu">
			<li><a href="main.jsp">YK BookStore</a>
			<li><a href="index_item.jsp">상품목록</a>
			<li><a href="userlogin.jsp">로그인</a>
			<li><a href="userjoin.jsp">회원가입</a>
			<li><a href="basket.jsp">장바구니</a>
			<li><a href="index_board.jsp">게시판</a>
		</ul>
	</nav><br>
	<h2 align="center">유저 로그인</h2>
	<form action="UserLoginController" method="POST">
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