<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<!--<a href="https://www.naver.com" onclick="if( confirm('이동 할래??') == false) return false;">naver</a>-->
	
	<script>
		var LoginFrom__submit = false;
		
		function JoinForm__submit(form){
			if(JoinForm__submitDone){
				alert('처리중 입니다.');
				return;
			}
			form.loginId.value = form.loginId.value.trim();
			
			if(form.loginId.value.length == 0){
				alert('로그인 아이디를 입력해주세요');
				form.loginId.focus();
				return;
			}
			form.loginPw.value = form.loginPw.value.trim();
			if (form.loginPw.value.length == 0) {
				alert('로그인 비밀번호를 입력해주세요.');
				form.loginPw.focus();
				return;
			}
			
			form.submit();
			JoinForm__submitDone = true;
		}
	</script>
	
	<!-- onsubmit이 return false인 경우 submit(제출)안함 -->
	<form action="doLogin" method = "POST" onsubmit = "LoginForm__submit(this); return false;"></form>
	<div>
	로그인 아이디 :  <input autocomplete = "off" placeholder = "로그인 아이디를 입력해주세요" name="loginId" type="text" />
	</div>
	<!-- type이 text인 경우 계속해서 띄워져 있고, password는 안띄워지게 -->
	<div>
	로그인 비밀번호 :  <input autocomplete = "off" placeholder = "로그인 비밀번호를 입력해주세요" name="loginPw" type="password" />
	</div>
	<div>
		<!-- <input type = "submit" value = "작성" /> -->
		<button type = "submit">로그인</button>
		<button type = "button"><a href="../home/main">취소</a></button>
	</div>
</body>
</html>