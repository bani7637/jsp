<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/sumCalculation">
		start : <input name=start type="text" />
		end : <input name=end type="text" /> <input type="submit" value="계산" />
	</form>
</body>
</html>