<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 관리 페이지</title>
</head>
<body>
<h2 align="center">관리자 페이지_상품 관리</h2>
<div align="center">
    <table border=1>
        <thead>
            <tr>
                <th>상품번호(Item Id)</th>
                <th>상품명(Name)</th>
                <th>작가(Author)</th>
                <th>가격(Price)</th>
                <th>수량(Quantity)</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${item_info}" var="item">
                <tr>
                    <td><c:out value="${item.itemid}" /></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.author}" /></td>
                    <td><c:out value="${item.price}원" /></td>
                    <td><c:out value="${item.qty}권" /></td>
                    <td><a href="ItemController?action=edit&itemId=<c:out value="${item.itemid}"/>">수정(Update)</a></td>
                    <td><a href="ItemController?action=delete&itemId=<c:out value="${item.itemid}"/>">삭제(Delete)</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ItemController?action=insert">상품 추가(Add Item)</a>
       <input type="button" value="관리자 페이지로 돌아가기" onclick="location.href='admin.jsp'"></p>
</div>
</body>
</html>