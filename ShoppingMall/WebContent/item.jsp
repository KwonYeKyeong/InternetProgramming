<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>관리자 상품 추가/수정 페이지</title>
</head>
<body>
	<h2 align="center">상품 정보</h2>
	<div align="center">
    <form method="POST" action='ItemController' name="frmAddItem">
        상품번호(Item ID) : <input type="text" readonly="readonly" name="itemid"
            value="<c:out value="${item.itemid}" />" /> <br /> 
        상품명(Name) : <input
            type="text" name="name"
            value="<c:out value="${item.name}" />" /> <br /> 
        작가(Author) : <input
            type="text" name="author"
            value="<c:out value="${item.author}" />" /> <br /> 
        가격(Price) : <input
            type="text" name="price"
            value="<c:out value="${item.price}" />" /> <br /> 
        수량(Quantity) : <input
            type="text" name="qty"
            value="<c:out value="${item.qty}" />" /> <br />
        상세설명(Memo) : <input type="text" name="memo"
            value="<c:out value="${item.memo}" />" /> <br /> <br>
            <input type="submit" value="확인" />
            <input type="button" value="상품 항목" onclick="location.href='index_itemlist.jsp'">
    </form>
    </div>
</body>
</html>