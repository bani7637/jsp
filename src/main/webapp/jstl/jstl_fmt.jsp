<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#lang").val("${param.lang == null ? 'ko':param.lang}");	
	$("#lang").on("change",function(){
		console.log("#lang change");
		document.lacation="/jstl/jstl_fmt.jsp?lang="+$("#lang").val();

		});
	});

</script>
</head>
<body>
	<!-- 1.jquery 라이브러리 추가
		 2.select box생성
		   option3가지 언어 선택가능
		 3. 페이지가 로딩 되었을떄 사용자가 요청한 언어로 \option태그가 선택이 된상태로 표현
		 4. 만약에 사용자가 언어설정 파라미터를 보내지 않앗을 경우 기본값으로 한국어가 설정하게끔
		 5. option태그가 바뀌면 자동으로 jst_fmt.jsp로 재요청
	
	 -->

	<!-- local 정보를 변경 -->
	<fmt:setLocale value="${param.lang == null ? 'ko':param.lang} "/>
	
	<select id="lang" name="lang">
		<option value="ko" selected">한국어</option>
		<option value="ja">일본어</option>
		<option value="en">영어</option>
	</select>
	
	<br><br>
	<!-- 사용할 리소스 번들 설정(리소스번들명_로케일.properties)
		kr.or.ddit.resource message_로케일.properties
	-->
	<% request.setAttribute("userId", "bani"); %>
	<fmt:bundle basename="kr.or.ddit.resources.message">
		<fmt:message key="GREETING" var="greeting"/>[${greeting}]<br>
		<fmt:message key="LOGIN_MSG">
			<fmt:param value="${userId }"/>
		</fmt:message>
	</fmt:bundle>
	<h3>setBundle</h3>
	<!-- set bundle : 번들 메시지를 변수에 저장하여 message태그에서 사용하게끔 하는 태그 -->
	<fmt:setBundle basename="kr.or.ddit.resources.message" var="msg"/>
	<fmt:message key="GREETING" bundle="${msg}"/>
	
</body>
</html>