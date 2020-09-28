<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>redirectView.jsp</h2>
	<table border="1">
		<tr>
			<th>이름</th>
		</tr>
		<!-- request객체에 저장된 rangers 속성을 이용하여 tr, td그리고 ranger 이름출력 -->
	<% List<String>list = (List<String>)request.getAttribute("rangers");
		for(String ranger : list){
	%>
		<tr>

			<td><%=ranger %></td>
		</tr>
		<% } %>

		
	</table>
</body>
</html>