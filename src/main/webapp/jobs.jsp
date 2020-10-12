<%@page import="kr.or.ddit.jobs.model.JobsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<% List<JobsVO>list = (List<JobsVO>)request.getAttribute("jobs"); %>
	<table border="1">
		<th>id</th>
		<th>title</th>
	<% for(JobsVO jobs : list){%>
		<tr><td> <%out.write(jobs.getJob_id());%></td><td><%out.write(jobs.getJob_title());%></td></tr>
	
	<%} %>
	</table>
</body>
</html>