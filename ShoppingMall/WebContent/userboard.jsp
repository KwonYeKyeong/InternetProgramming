<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/mainnav.css" rel="stylesheet"/>
<title>게시판목록 페이지</title>
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
	<table border=1>
        <thead>
            <tr>
                <th>제목(Title)</th>
                <th>작성자(Writer)</th>
                <th>작성일(Date)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${board_info}" var="board">
                <tr>
                    <td><c:out value="${board.title}" /></td>
                    <td><c:out value="${board.writer}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${board.date}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="userwriteboard.jsp">게시글 작성하기</a>
</body>
</html>