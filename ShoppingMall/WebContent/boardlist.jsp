<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 관리 페이지</title>
</head>
<body>
<h2 align="center">관리자 페이지_게시판 관리</h2>
	<div align="center">
    <table border=1>
        <thead>
            <tr>
                <th>게시글번호(Board Id)</th>
                <th>제목(Title)</th>
                <th>작성자(Writer)</th>
                <th>작성일(Date)</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${board_info}" var="board">
                <tr>
                    <td><c:out value="${board.boardid}" /></td>
                    <td><c:out value="${board.title}" /></td>
                    <td><c:out value="${board.writer}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${board.date}" /></td>
                    <td><a href="BoardController?action=edit&boardId=<c:out value="${board.boardid}"/>">수정(Update)</a></td>
                    <td><a href="BoardController?action=delete&boardId=<c:out value="${board.boardid}"/>">삭제(Delete)</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="BoardController?action=insert">게시글 추가(Add Post)</a>
       <input type="button" value="관리자 페이지로 돌아가기" onclick="location.href='admin.jsp'"></p>
    </div>
</body>
</html>