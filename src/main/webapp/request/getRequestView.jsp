<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#select1').on('click', function(){
		res = $(this).val();
		console.log(res)
 		$('#form1').attr(res)
		})

	$('#select2').on('click', function(){
		res = $(this).val();
		console.log(res)
 		$('#form1').attr(res)
		})


		
})
</script>
</head>
<body>
<%--
	파라미터 : client 서버로 요청을 보낼때 추가적으로 보낸 값
			 ex : 로그인 요청시 => 사용자 id, 비밀번호 
			 
	 파라미터는 내부적으로 Map<String, String[]> 객체로 관리를 한다.
					    파라미터이름, 파라미터 값들
					    => 동일한 이름의 파라미터를 여러개 보낼 수 있다.
					    		 
	request 객체에 있는 파라미터 관련 메소드 4가지
	
	getParameter(String param) : param에 해당하는 파라미터 값을 조회한다.
								 파라미터맵에서 첫번째 값을 반환
	
	String[] getParameterValues(String param) : param에 해당하는 모든 파라미터 값을 반환한다.
	
	Map<String, String[]> getParameterMap() : request객체에 생성된 파라미터 맵을 반환
	
	Enumeration<String> getParameterNames() : request객체에 담긴 모든 파라미터 이름을 반환						 		 
--%>

<%--
	한글 파라미터 설정 
	get : server.xml<Connect URIEncoding ="UTF-8">
	post : request.setCharacterEncoding("utf-8");
		   request.getParameter()메서드를 호출하기전에 설정을 해줘야한다.
--%>
	

<%-- action : 요청을 보낼 경로 --%>
<%-- method : 요청 방식(get, post 2가지만 가능, 기본 => get) --%>
	<form action="<%= request.getContextPath() %>/request/getRequestResponse.jsp" method="get" id="form1">
		<label for="id">user id : </label><input type="text" name="id" value="바니"><br>
		<label for="id">user id : </label><input type="text" name="id" value="샐리"><br>
		<label for="pass">password : </label><input type="password" value="pass1234"
			name="pass"><br> <input type="submit" value="전송">
	</form>
	
	
	GET, POST 두가지를 선택할 수 있는 라디오 버튼을 만들어서 FORM전송시 사용자가 GET, POST방식을 지정 할 수 있도록한다.<br><br>
	GET<input type="radio" id="select1" value="get"> &nbsp;&nbsp;&nbsp;&nbsp;
	POST<input type="radio" id="select2" value="post">
	
</body>
</html>