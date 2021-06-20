<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link type="text/css" href="css/mainnav.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>유저 회원가입 페이지</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>
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
	<h2 align="center">유저 회원가입</h2>
	<div align="center">
    <form method="POST" action='UserController?action=userjoin' name="frmAddUser">
        아이디(ID) : <input
            type="text" name="id"
            value="<c:out value="${user.id}" />" /> <br /> 
        비밀번호(PW) : <input
            type="text" name="pw"
            value="<c:out value="${user.pw}" />" /> <br /> 
        이름(Name) : <input
            type="text" name="name"
            value="<c:out value="${user.name}" />" /> <br /> 
        생년월일(Date Of Birth) : <input
            type="text" name="dob"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> <br /> 
        주소(Address) : <input type="text" name="address"
            value="<c:out value="${user.address}" />" /> <br /> <br>
            <input type="submit" value="확인" />
    </form>
    </div>
</body>
</html>