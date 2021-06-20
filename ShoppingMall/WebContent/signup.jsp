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
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>관리자 회원 추가/수정 페이지</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>
	<h2 align="center">회원 정보</h2>
	<div align ="center">
    <form method="POST" action='UserController?action=adduser' name="frmAddUser">
        회원번호(User ID) : <input type="text" readonly="readonly" name="userid"
            value="<c:out value="${user.userid}" />" /> <br /> 
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
            <input type="button" value="유저 항목" onclick="location.href='index_userlist.jsp'">
    </form>
    </div>
</body>
</html>