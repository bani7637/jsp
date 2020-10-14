<%@page import="kr.or.ddit.jobs.model.JobsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/layout/commonLib.jsp"%>
</head>
<body>
	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<%
					List<JobsVO> list = (List<JobsVO>) request.getAttribute("jobs");
				%>
				<h2 class="sub-header">jobs</h2>
				<table class="table table-striped">
					<th>id</th>
					<th>title</th>
					<%
						for (JobsVO jobs : list) {
					%>
					<tr>
						<td>
							<%
								out.write(jobs.getJob_id());
							%>
						</td>
						<td>
							<%
								out.write(jobs.getJob_title());
							%>
						</td>
					</tr>

					<%
						}
					%>
				</table>
			</div>
</body>
</html>