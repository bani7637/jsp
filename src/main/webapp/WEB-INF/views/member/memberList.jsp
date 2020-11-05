<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<%@ include file="/WEB-INF/views/layout/commonLib.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#memberList tr").on("click",function(){
			//data-userid
			var userid = $(this).data("userid");
			console.log("userid : "+userid);		
			location.href = "/member/member?userid="+userid;
			});
		});
		 
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href = "/member/memberList?pageSize=" + sel;
	}
	
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/WEB-INF/views/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								<tbody id="memberList">
									<%
										request.getAttribute("memList");
									%>
									<c:forEach items="${memList}" var="member">
										<tr data-userid="${member.userid}">

											<td>${member.userid}</td>
											<td>${member.usernm}</td>
											<td>${member.alias}</td>
											<td><fmt:formatDate value="${member.reg_dt}"
													pattern="yyyy-MM-dd" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<select id="cntPerPage" name="sel" onchange="selChange()">
							<option value="">줄선택</option>
							<option value="5" <c:if test="${cntPerPage == 5}">selected</c:if>>5줄
								보기</option>
							<option value="6" <c:if test="${cntPerPage == 6}">selected</c:if>>6줄
								보기</option>
							<option value="7" <c:if test="${cntPerPage == 7}">selected</c:if>>7줄
								보기</option>
							<option value="8" <c:if test="${cntPerPage == 8}">selected</c:if>>8줄
								보기</option>
							<option value="10"
								<c:if test="${cntPerPage == 10}">selected</c:if>>10줄 보기</option>
						</select> 
						
						<a class="btn btn-default pull-right" href="${pageContext.request.contextPath }/member/memberRegist">사용자 등록</a>
						
						<div class="text-center">
							<ul class="pagination">
								<c:forEach begin="1" end="${pages }" var="i">
									<c:choose>
										<c:when test="${i == page}">
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${pageContext.request.contextPath }/member/memberList?page=${i}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
