<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<script type="text/javascript">
	$(document).ready(function(){
		$("#updatemem").on("click", function(){
			var userid1 = "${memberVO.userid}"
			location.href="memUpdate?userid="+userid1;
			});
		$("#deletemem").on("click",function(){
			var userid2 = "${memberVO.userid}"
			location.href="memDelete?userid="+userid2;
		});
		
		$("#profileDownBtn").on("click",function(){
			var userid3 ="${memberVO.userid}"
				location.href ="${cp }/profile/profileDownload?userid="+userid3;
		});
		
	});
</script>

<body>
	tiles : 
		<div class="row">

		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form">


					<div class="form-group row">
						<label for="userfile" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img src="${cp }/profile/profileImg?userid=${memberVO.userid}"/>
							
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="profileDownBtn">다운로드:${memberVO.realFilename }</button>
						</div>
					</div>	
				
					<div class="form-group row">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVO.userid }</label>
						</div>
					</div>

					<div class="form-group row">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVO.usernm }</label>
						</div>
					</div>
					<div class="form-group row">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVO.alias }</label>
						</div>
					</div>
					<div class="form-group row">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label class="control-label">******</label>
						</div>
					</div>
					
					
					<div class="form-group row">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVO.addr1 }</label>
						</div>
					</div>
					<div class="form-group row">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVO.addr2 }</label>
						</div>
					</div>
					<div class="form-group row">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVO.zipcode }</label>
						</div>
					</div>
					<div class="form-group row">
						<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${memberVO.reg_dt }" pattern="YYYY-MM-dd"/></label>
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="updatemem">사용자 수정</button>
							<button type="button" class="btn btn-default" id="deletemem">사용자 삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
</body>
</html>
