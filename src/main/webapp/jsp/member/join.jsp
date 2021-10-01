<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<!-- onsubmit이 return false인 경우 submit(제출)안함 -->
	<form action="doJoin" method = "POST" onsubmit = "JoinForm__submit(this); return false;"></form>
	<div>
	로그인 아이디 :  <input autocomplete = "off" placeholder = "로그인 아이디를 입력해주세요" name="loginId" type="text" />
	</div>
	<!-- type이 text인 경우 계속해서 띄워져 있고, password는 안띄워지게 -->
	<div>
	로그인 비밀번호 :  <input autocomplete = "off" placeholder = "로그인 비밀번호를 입력해주세요" name="loginPw" type="password" />
	</div>
	<div>
	로그인 비밀번호 확인 :  <input autocomplete = "off" placeholder = "로그인 비밀번호 확인을 입력해주세요" name="loginPwConfirm" type="password" />
	</div>
	<div>
	이름 :  <input autocomplete = "off" placeholder = "이름을 입력해주세요" name="name" type="text" />
	</div>
	<div>
		<!-- <input type = "submit" value = "작성" /> -->
		<button type = "submit">가입</button>
		<button type = "button"><a href="../home/main">취소</a></button>
	</div>
</body>
</html>