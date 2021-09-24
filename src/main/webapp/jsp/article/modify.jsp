<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
	<h1>게시물 수정</h1>
	<div>번호 : <%=(int)articleRow.get("id") %></div>
	<div>날짜 : <%=(LocalDateTime)articleRow.get("regDate") %></div>
	<div>제목 : </div>
	<div>내용 : </div>
	<div><a href="list">리스트로 돌아가기</a></div>
</body>
</html>