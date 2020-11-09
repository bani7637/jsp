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

<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
		$("#zipcodeBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					$("#addr1").val(data.roadAddress);
					$("#zipcode").val(data.zonecode);
				}
			}).open();
		});

		$("#regBtn").on("click",function(){
				$("#frm").submit();
		});
	});

	
	
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
				<form class="form-horizontal" role="form" id="frm" action="${cp}/member/memUpdate" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userid" name="userid"
								value="${memberVO.userid }" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="usernm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="usernm" name="usernm"
								placeholder="이름을 입력하세요" value="${memberVO.usernm }">
						</div>
					</div>
					<div class="form-group">
						<label for="userfile" class="col-sm-2 control-label">사용자
							사진</label>
						<div class="col-sm-10">
						<img src="${cp }/profile/profileImg?userid=${memberVO.userid}"/>
							<input type="file" id="realfilename" name="realfilename">
							
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias"
								placeholder="별명을 입력하세요" value="${memberVO.alias }">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="비밀번호를 입력하세요" value="${memberVO.pass }">
						</div>
					</div>
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1"
								name="addr1" value="${memberVO.addr1 }" placeholder="우편번호찾기를 이용하세요" readonly >
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" class="btn btn-default" value="우편번호 찾기"
								id="zipcodeBtn"><br>
						</div>
					</div>
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2"
								name="addr2" value="${memberVO.addr2 }"placeholder="상세주소를 입력하세요">
						</div>
					</div>
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" value="${memberVO.zipcode }"class="form-control" id="zipcode"
								name="zipcode" placeholder="우편번호찾기를 이용하세요" readonly>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="regBtn">수정하기</button>
						</div>
					</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>
