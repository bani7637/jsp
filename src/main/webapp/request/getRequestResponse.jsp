<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<h1>GET</h1>
	
	예상 => userId 파라미터는 bani, sally 두개를 보내지만 getParameter호출하면 첫번째 파라미터 값(bani)을 반환<br>
	request.getParameter("userId") : <%= request.getParameter("id") %><br><br>

	String[]을 반환<br>
	request.getParameterValues("userId") :
	<% 
	String[] userIds = request.getParameterValues("id");
	for(String userId : userIds){
	%>
	<%= userId %>
	<% 
	}
	%><br><br>
	
	parameterMap : Map<String, String[]>
	request.getParameterMap():<%= request.getParameterMap() %><br><br>
	
	
	요청에 존재하는 파라미터 이름 출력하기
	Enumeration<String> getParameterNames() :		
	
	<%
	Enumeration<String> names = request.getParameterNames();
	while (names.hasMoreElements()) {
	String name = names.nextElement();
	%>
	
	<%=name%> : <%= request.getParameterNames() %><br>
	<%
		}
	%>
	
	
	
</body>
</html>