<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
int dan = 8;
%>
<!--�ڹٹ��� ����ϰ� �������� <% %>���ؼ� ����ϸ� ��!! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ���</title>
</head>
<body>
	<div>== <% out.print(dan); %>�� ==</div>
	
	<!--�ڹٹ����� html������ ���� ��� ������-->
	<%for(int i =1; i<=9; i++){ %>
	<div><%=dan %> * <%=i %> = <%=dan*i %></div>
	<%} %>

</body>
</html>