<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
int loginedMemberId = (int) request.getAttribute("loginedMemberId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

	<h1>메인페이지</h1>

	<%
	if (isLogined) {
	%>
	<div>
	<%=loginedMemberId %> 번 회원님 환영합니다.
		<a href="../member/doLogout">로그아웃</a>
	</div>
	<%
	}
	%>

	<%
	if (!isLogined) {
	%>
	<div>
		<a href="../member/login">로그인</a>
	</div>
	<%
	}
	%>

	<div>
		<a href="../article/list">게시물 리스트</a>
	</div>
	
</body>
</html>