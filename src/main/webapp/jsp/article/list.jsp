<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.sbs.java.am.dto.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Article> articles = (List<Article>) request.getAttribute("articles");
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
	
	<%@ include file="../part/topBar.jspf" %>
	
	<div><a href="write">게시물 작성</a></div>
	
	<table border = "1">
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>제목</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
				
		</thead>
		
		<tbody>
			<%
			for (Article article : articles) {
			%>
			<tr>
				<td><%=article.id %></td>
				<td><%=article.regDate %></td>
				<td><a href="detail?id=<%=article.id%>"><%=article.title%></a></td>
				<td>
				<a href="modify?id=<%=article.id %>">수정</a>
				</td>
				<td>
				<a href="doDelete?id=<%=article.id %>">삭제</a>
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

	<%
	/* cPage => 현재페이지 */
	if(cPage > 1){ %>
	<a href="list?page=1">◀</a>
	<% }%>
	<% int pageMenuSize = 5;
	int from = cPage - pageMenuSize;
	if(from < 1){
		from = 1;
	}
	int end = cPage + pageMenuSize;
	if(end>totalpage){
		end = totalpage;
	}
	for(int i = from; i<=end; i++){ %>
	<a class="<%=cPage==i?"red":""%>" href="list?page=<%=i %>"><%=i%></a>
	<%} %>
	<%if(cPage<totalpage){ %>
	<a href="list?page=<%=totalpage %>">▶</a>
	<%} %>
	
	</div>
</body>
</html>