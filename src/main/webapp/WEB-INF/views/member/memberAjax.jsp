<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<script type="text/javascript">
	$(document).ready(function() {
		//client side 에서는 서버사이드 변수나 값을 사용가능
		memberAjax("${param.userid}");

				$("#updatemem").on("click", function(){
					var userid1 = "${param.userid}"
					location.href="memUpdate?userid="+userid1;
					});
				$("#deletemem").on("click",function(){
					var userid2 = "${param.userid}"
					location.href="memDelete?userid="+userid2;
				});

				$("#profileDownBtn").on("click",function(){
					var userid3 ="${param.userid}"
						location.href ="${cp }/profile/profileDownload?userid="+userid3;
				});

	});

	function memberAjax(userid) {
		$.ajax({
			url : "/member/getmemberAjax",
			method : "get",
			data : {
				userid : userid
			},
			success : function(data) {
				console.log(data);
				
				$("#profile").attr("src","${cp }/profile/profileImg?userid="+data.memberVO.userid);
				$("#userid").html(data.memberVO.userid);
				$("#userNm").html(data.memberVO.usernm);
				$("#alias").html(data.memberVO.alias);
				$("#addr1").html(data.memberVO.addr1);
				$("#addr2").html(data.memberVO.addr2);
				$("#zipcode").html(data.memberVO.zipcode);
				$("#reg_dt").html(data.memberVO.fmt_reg_dt);
				$("#profileDownBtn").html(data.memberVO.realFilename);

			}

		});

	}
</script>

<body>
	tiles :
	<div class="row">


		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<form class="form-horizontal" role="form">


				<div class="form-group">
					<label for="userfile" class="col-sm-2 control-label">사용자 사진</label>
					<div class="col-sm-10" >
					<img id="profile" src="${cp }/profile/profileImg?userid=${memberVO.userid}"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default" id="profileDownBtn"></button>
					</div>
				</div>

				<div class="form-group">
					<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
					<div class="col-sm-10">
						<label class="control-label" id="userid"></label>
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
					<div class="col-sm-10">
						<label class="control-label" id="userNm"></label>
					</div>
				</div>
				<div class="form-group">
					<label for="alias" class="col-sm-2 control-label">별명</label>
					<div class="col-sm-10">
						<label class="control-label" id="alias"></label>
					</div>
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<label class="control-label">******</label>
					</div>
				</div>


				<div class="form-group">
					<label for="addr1" class="col-sm-2 control-label">주소</label>
					<div class="col-sm-10">
						<label class="control-label" id="addr1"></label>
					</div>
				</div>
				<div class="form-group">
					<label for="addr2" class="col-sm-2 control-label">상세주소</label>
					<div class="col-sm-10">
						<label class="control-label" id="addr2"></label>
					</div>
				</div>
				<div class="form-group">
					<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
					<div class="col-sm-10">
						<label class="control-label" id="zipcode"></label>

					</div>
				</div>
				<div class="form-group">
					<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
					<div class="col-sm-10">
						<label class="control-label" id="reg_dt"></label>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default" id="updatemem">사용자
							수정</button>
						<button type="button" class="btn btn-default" id="deletemem">사용자
							삭제</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
