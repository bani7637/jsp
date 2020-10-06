<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("getServerInfo() : " + application.getServerInfo()+"<br>");
		out.println("getContextPath() : " + application.getContextPath()+"<br>");
		out.println("getMajorVersion() : " + application.getMajorVersion()+"<br>");
		out.println("getMinorVersion() : " + application.getMinorVersion()+"<br>");
		
		out.println("<br>");
		out.println("web.xml에 설정 정보(초기화 파라미터 - initParameter)를 불러 올 수도 있지만 자주 사용하지 않음. <br>");
		
		String dbUserId =application.getInitParameter("dbUserId");
		out.println("dbUserId : "+dbUserId);
				
		
	%>
</body>
</html>