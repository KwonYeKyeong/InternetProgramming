<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/mainnav.css" rel="stylesheet"/>
<title>상품목록 페이지</title>
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
	<form action="ItemController?action=order&itemid=<c:out value="${item.itemid}"/>">
	<table border=1>
        <thead>
            <tr>
            	<th>주문(Order)</th>
                <th>상품명(Name)</th>
                <th>작가(Author)</th>
                <th>가격(Price)</th>
                <th>수량(Quantity)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${item_info}" var="item">
                <tr>
                	<td><input type="checkbox" name="itemid" value="<c:out value="${item.itemid}" />"></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.author}" /></td>
                    <td><c:out value="${item.price}원" /></td>
                    <td><c:out value="${item.qty}권" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><input type="submit" value="구매하기">&nbsp<input type="reset" value="초기화하기"></p>
    </form>
</body>
</html>