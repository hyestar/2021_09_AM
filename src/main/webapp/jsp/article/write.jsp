<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>
	<h1>게시물 작성</h1>
	<!-- action은 편지지라고 생각했을때 받는 사람의 주소-->
	<form action="dowrite" method="post">
		<div>제목 : <input autocomplete = "off" placeholder = "제목을 입력해주세요" name="title" type="text" /></div>
		<div>내용 : <textarea cols="30" rows="10" placeholder = "내용을 입력해주세요" name = "body"/></textarea></div>
		<div>
			<!-- button과 동일한 기능 그러나 꾸미기에 버튼이 더 쉽다.
			 <input type="submit" value = "작성"/> -->
			<button type = "submit">작성</button>
			<a href="list">리스트로 돌아가기</a>
		</div>
	</form>
</body>
</html>