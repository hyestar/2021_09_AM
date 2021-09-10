<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
int dan = 8;
%>
<!--자바문법 사용하고 싶을때는 <% %>로해서 사용하면 됨!! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구구단 출력</title>
</head>
<body>
	<div>== <% out.print(dan); %>단 ==</div>
	
	<!--자바문법과 html문법을 같이 사용 가능함-->
	<%for(int i =1; i<=9; i++){ %>
	<div><%=dan %> * <%=i %> = <%=dan*i %></div>
	<%} %>

</body>
</html>