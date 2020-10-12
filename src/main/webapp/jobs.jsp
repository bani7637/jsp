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
	<% for(JobsVO jobs : list){%>
		job_id : <%out.write(jobs.getJob_id());%>
		job_title : <%out.write(jobs.getJob_title());%><br>
	<%} %>
</body>
</html>