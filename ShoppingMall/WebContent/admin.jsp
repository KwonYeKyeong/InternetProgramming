<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<h2 align="center">관리자 페이지</h2>
	<form>
		<table align="center">
			<tr align="center">
				<td><input type="button" value="유저 관리" onclick="location.href='index_userlist.jsp'"></td>
			</tr>
			<tr align="center">
				<td><input type="button" value="상품 관리" onclick="location.href='index_itemlist.jsp'"></td>
			</tr>
			<tr align="center">
				<td><input type="button" value="게시판 관리" onclick="location.href='index_boardlist.jsp'"></td>
			</tr>
		</table>
		<br><p align="center"><input type="button" value="쇼핑몰로 돌아가기" onclick="location.href='main.jsp'">
	</form>
</body>
</html>