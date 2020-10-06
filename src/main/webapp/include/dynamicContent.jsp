<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1>
	 	<%
	 		request.getRequestDispatcher("/include/heager.jsp").include(request, response);
	 	%>
	dynamicContent.jsp
	param : <%= request.getParameter("param") %>	 
	 </h1>
</body>
</html>