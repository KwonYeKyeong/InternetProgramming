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
<title>관리자 게시글 추가/수정 페이지</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=date]').datepicker();
        });
    </script>
	<h2 align="center">게시글 정보</h2>
	<div align="center">
    <form method="POST" action='BoardController?action=adminwrite' name="frmAddPost">
        게시글번호(Board ID) : <input type="text" readonly="readonly" name="boardid"
            value="<c:out value="${board.boardid}" />" /> <br /> 
        제목(Title) : <input
            type="text" name="title"
            value="<c:out value="${board.title}" />" /> <br /> 
        작성자(Writer) : <input
            type="text" name="writer"
            value="<c:out value="${board.writer}" />" /> <br />
        작성일(Date) : <input
            type="text" name="date"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${board.date}" />" /> <br /> 
        내용(Memo) : <input type="text" name="memo"
            value="<c:out value="${board.memo}" />" /> <br /> <br>
            <input type="submit" value="확인" />
            <input type="button" value="게시판 항목" onclick="location.href='index_boardlist.jsp'">
    </form>
    </div>
</body>
</html>