<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/mulCalculation">
		param1 : <input name=param1 type="text" /> 
		param2 : <input name=param2 type="text" />
				 <input type="submit" value="계산" />
	</form>
</body>
</html>