<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유저 관리 페이지</title>
</head>
<body>
<h2 align="center">관리자 페이지_유저 관리</h2>
    <table border=1>
        <thead>
            <tr>
                <th>회원번호(User Id)</th>
                <th>아이디(ID)</th>
                <th>비밀번호(PW)</th>
                <th>이름(Name)</th>
                <th>생년월일(DOB)</th>
                <th>주소(Address)</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${user_info}" var="user">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.pw}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}" /></td>
                    <td><c:out value="${user.address}" /></td>
                    <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">수정(Update)</a></td>
                    <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">삭제(Delete)</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="UserController?action=insert">회원 추가(Add User)</a>
       <input type="button" value="관리자 페이지로 돌아가기" onclick="location.href='admin.jsp'"></p>
</body>
</html>