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
	<form action="domodify" method="POST">
			<!-- 		<input type="hidden" name="id" -->
			<%-- 			value="<%=Integer.parseInt(request.getParameter("id"))%>" /> --%>
		<!-- get값으로 넘어온 정보를 ${param.~}으로 받을 수 있다 
		${param.id}를 예시로 들면 param은 파라미터 값으로 넘어온 데이터를 뜻하고, id는 데이터중에서 id라는 이름을 갖는 데이터 값을 가져온다는 것이다.
		${param.id}는 request.getParameter("id")와 같다. -->
		<input type="hidden" name="id" value="${param.id }" />
		<div>번호 : <%=(int)articleRow.get("id") %></div>
		<div>날짜 : <%=(LocalDateTime)articleRow.get("regDate") %></div>
		<!-- autocomplete 자동완성기능, placeholder 사용자가 입력필드에 제대로 값을 입력할 수 있도록 설명해놓은것 -->
		<div>제목 : <input autocomplete="off" type="text" name = "title" placeholder="제목을 입력해주세요" 
			value = "<%=(String) articleRow.get("title") %>"/></div>
		<!-- textarea태그는 input태그와 달리 꼭 닫는 태그를 적어줘야한다. -->
		<div>내용 : <textarea autocomplete="off" name="body" placeholder="내용을 입력해주세요"><%=(String) articleRow.get("body") %></textarea></div>
		<div>
			<button type="submit">수정</button>
			<a href="list">리스트로 돌아가기</a>
		</div>
	</form>
</body>
</html>