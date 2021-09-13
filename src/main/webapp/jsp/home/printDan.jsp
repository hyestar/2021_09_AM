<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
int limit = Integer.parseInt(request.getParameter("limit"));
String color = request.getParameter("color");
%>
<!--자바문법 사용하고 싶을때는 <% %>로해서 사용하면 됨!! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
	<div style = "color:<%=color %>;">== <%=dan %>단 ==</div>
	
	<!--자바문법과 html문법을 같이 사용 가능함-->
	<%for(int i =1; i<=limit; i++){ %>
	<div style = "color:<%=color %>;"><%=dan %> * <%=i %> = <%=dan*i %></div>
	<%} %>

</body>
</html>