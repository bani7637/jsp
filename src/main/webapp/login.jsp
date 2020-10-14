<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/signin.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/js.cookie-2.2.1.min.js"></script>
<script type="text/javascript">
	//쿠키값 가져오기
	function getCookieValues(cookieName) {
		// 		alert(document.cookie)
		// 		console.log(cookieName)
		var cookies = document.cookie.split("; ");

		for (var i = 0; i < cookies.length; i++) {
			var cookie = cookies[i];

			var cookieArr = cookie.split("=");

			if (cookieName == cookieArr[0]) {
				return cookieArr[1];
			}
		}
		return "";
	}

	//쿠키설정하기(쿠키설정할때 주로 날짜로 지정해줌)
	function setCookie(cookieName, cookieValue, expries) {
		//"USERNM=brown; path=/; expires=wed, 07 Oct 2020 00:38:35 GMT;"

		var today = new Date();
		//현재날짜에서 미래로 + expires만큼 날짜 구하기
		today.setDate(today.getDate() + expries);
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires="
				+ today.toGMTString();
		console.log(document.cookie);
	}

	//해당쿠키의 expires속성을 과거날짜로 지정하여 삭제
	function deleteCookie(cookieName) {
		setCookie(cookieName, "", -1);
	}

	$(function() {
		// 1. 쿠키값 Y인지 확인
		if (getCookieValues("REMEMBERME") == "Y") {
			// 2. 1번 충족시 checked="checked"상태변경
			$("input:checkbox[id='remember']").prop("checked", true);
			$("#remember").prop("checked", true);
			// 3. usernm확인후 값설정 
			getCookieValues("USERNM")
			console.log(getCookieValues("USERNM"));
			document.getElementById('inputEmail').value = getCookieValues("USERNM")
		}

		// 새로운 사용자가 rememberme를 클릭했을때 쿠키값설정하기
		$('#Signin').on('click', function() {
			if ($("input:checkbox[id='remember']").prop("checked") == true) {

				setCookie('REMEMBERME', 'Y');
				setCookie('USERNM', $('#inputEmail').val());
			} else {
				Cookies.remove('REMEMBERME');
				Cookies.remove('USERNM');
			}
			$("form").submit();
		});
	});
</script>

</head>

<body>

	<div class="container">
		<form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="email" id="inputEmail" name="userId" value="brown" class="form-control" placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only" >Password</label>
			<input type="password" id="inputPassword" required value="passBrown" class="form-control" placeholder="Password" required name="password">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me" id="remember">Remember me</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="button" id="Signin">Sign in</button>
		</form>
	</div>

</body>
</html>
