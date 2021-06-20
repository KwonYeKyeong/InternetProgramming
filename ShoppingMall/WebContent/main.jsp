<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/mainnav.css" rel="stylesheet"/>
<title>쇼핑몰 메인 페이지</title>
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
	<img src="https://i2.wp.com/www.simplyangella.com/wp-content/uploads/2019/11/korean-bookstore-in-seoul.jpg?resize=1024%2C768&ssl=1"
		width="845px" height="450px" alt="YK BookStore"><br>
	<p align="center"><input type="button" value="관리자로 로그인하기" onclick="location.href='adminlogin.jsp'">
</body>
</html>