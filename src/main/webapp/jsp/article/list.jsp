<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
int cPage = (int) request.getAttribute("page");
int totalpage = (int) request.getAttribute("totalpage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%-- <h1>게시물 리스트 v1</h1>
<ul>
	<li><%=(int) articleRows.get(0).get("id") %>번, <%=articleRows.get(0).get("regDate") %>, <%=(String) articleRows.get(0).get("title") %></li>
	<li><%=(int) articleRows.get(1).get("id") %>번, <%=articleRows.get(1).get("regDate") %>, <%=(String) articleRows.get(1).get("title") %></li>
	<li><%=(int) articleRows.get(2).get("id") %>번, <%=articleRows.get(2).get("regDate") %>, <%=(String) articleRows.get(2).get("title") %></li>
</ul>

<h1>게시물 리스트 v2</h1>
<ul>

	<%for(int i = 0; i < 3; i++){ %>
	<li><%=(int) articleRows.get(i).get("id") %>번, <%=articleRows.get(i).get("regDate") %>, <%=(String)articleRows.get(i).get("title") %></li>	
	<%} %>
	
</ul>

<h1>게시물 리스트 v3</h1>
<ul>

	<%for(int i = 0; i < 3; i++){ 
		Map<String, Object> articleRow = articleRows.get(i);
	%>
	<li><%=(int) articleRow.get("id") %>번, <%=articleRow.get("regDate") %>, <%=(String)articleRow.get("title") %></li>	
	<%} %>
	
</ul>

<h1>게시물 리스트 v4</h1>
<ul>

	<%for(int i = 0; i < articleRows.size(); i++){ 
		Map<String, Object> articleRow = articleRows.get(i);
	%>
	<li><%=(int) articleRow.get("id") %>번, <%=articleRow.get("regDate") %>, <%=(String)articleRow.get("title") %></li>	
	<%} %>
	
</ul>
 --%>
<%-- 	<h1>게시물 리스트</h1>
	<ul>
		<%
		for (Map<String, Object> articleRow : articleRows) {
		%>
		<li><a href="detail?id=<%=(int) articleRow.get("id")%>"><%=(int) articleRow.get("id")%>번, <%=articleRow.get("regDate")%>,
				<%=(String) articleRow.get("title")%></a></li>
		<%
		}
		%>

	</ul> --%>
	<h1>게시물 리스트</h1>
	<table border = "1">
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>제목</th>
				<th>삭제</th>
			</tr>
				
		</thead>
		
		<tbody>
			<%
			for (Map<String, Object> articleRow : articleRows) {
			%>
			<tr>
				<td><%=articleRow.get("id") %></td>
				<td><%=articleRow.get("regDate") %></td>
				<td><a href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a></td>
				<td>
				<a href="doDelete?id=<%=articleRow.get("id") %>">삭제하기</a>
				</td>
			<%} %>
		</tbody>
	</table>
	
	<style type = "text/css">
		.page>a.red{
			color:red;
		}
	
	</style>

	<div class="page">
	<%for(int i = 1; i<=totalpage; i++){ %>
	<a class="<%=cPage==i?"red":""%>" href="list?page=<%=i %>"><%=i%></a>
	<%} %>
	</div>
</body>
</html>