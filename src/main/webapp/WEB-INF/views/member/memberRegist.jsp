<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
		//client side - validation
		//server side - validation
		//두개다 해줘야 안전함 일단생략 스프링수업때할예정
				$("#frm").submit();
		});
		//initData();
	});

	function initData(){
		$("#userid").val("bani");	
		$("#usernm").val("반이슬");	
		$("#alias").val("bani");	
		$("#pass").val("1234");	
		$("#addr1").val("대전 중구 중앙로 76");	
		$("#addr2").val("영민빌딩 4층 404호");	
		$("#zipcode").val("34904");	
	}
</script>


<body>
	tiles :
		<div class="row">
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form" id="frm" action="${cp}/member/memberRegist" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userid" name="userid"
								placeholder="사용할 아이디를 입력하세요">
						</div>
					</div>

					<div class="form-group">
						<label for="usernm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="usernm" name="usernm"
								placeholder="이름을 입력하세요" value="${param.usernm }">
								<span style="color: red;"><form:errors path="memberVO.usernm"/></span>
								
								
						</div>
					</div>
					<div class="form-group">
						<label for="userfile" class="col-sm-2 control-label">사용자
							사진</label>
						<div class="col-sm-10">
							<input type="file" id="realfilename" name="realfilename" >
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias"
								placeholder="별명을 입력하세요" value="${param.alias }">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="비밀번호를 입력하세요" value="${param.pass }">
						</div>
					</div>
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1"
								name="addr1" value="${param.addr1 }" placeholder="우편번호찾기를 이용하세요" readonly >
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
								name="addr2" value="${param.addr2 }"placeholder="상세주소를 입력하세요">
						</div>
					</div>
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" value="${param.zipcode }"class="form-control" id="zipcode"
								name="zipcode" placeholder="우편번호찾기를 이용하세요" readonly>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="regBtn">사용자 등록</button>
						</div>
					</div>
			</form>
		</div>
	</div>

</body>
</html>
