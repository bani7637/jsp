<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
	$(document).ready(function() {
		// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json 으로 받는다.
		memberListAjaxHTML(1);

		// ajax로 생성한거니까 생성하면서 바로 이벤트 등록해줘야함// 현재 동적이벤트 생성함 tr태그가 있으면 등록
		$("#memberList").on("click", "tr", function() {
			//data-userid
			var userid = $(this).data("userid");
			console.log("userid : " + userid);
			location.href = "/member/memberAjaxPage?userid=" + userid;

		});
	});

	function memberListAjax(p) {
		$.ajax({
			url : "/member/listAjax",
			method : "get",
			//date 보내는 방식 3가지
			data : {
				page : p,
				pageSize : 5
			}, // 폼방식으로 보냄(객체로 보냄?)
			//data : "page=1&pageSize=5, 	// 파라미터로 보냄 
			//data : JSON.stringify({page : 1, pageSize :5}) //json <->javaObj 
			success : function(data) {
				var i = 0;
				// memberlist tbody영역에 들어갈 html 문자열 생성
				var html = "";
				for (var i = 0; i < data.memList.length; i++) {
					var member = data.memList[i];
					html += "<tr data-userid='"+ member.userid+"'>";
					html += " <td>" + member.userid + "</td>";
					html += " <td>" + member.usernm + "</td>";
					html += " <td>" + member.alias + "</td>";
					html += " <td>" + member.fmt_reg_dt + "</td>";
					html += "</tr> ";
				}
				$("#memberList").html(html);
				//페이지 내비게이션 html 문자열 동적으로 생성하기
				var j = 1;
				var nav = "";
				for (var j = 1; j <= data.pages; j++) {
					if (j == data.pageVO.page) {
						nav += "<li class=\"active\"><span>" + j
								+ "</span></li>"
					} else {
						//<a href ="javascript:memberListAjax(1);"/>
						nav += "<li><a href=\"javascript:memberListAjax(" + j
								+ ");\">" + j + "</a></li>"
					}
				}

				$(".pagination").html(nav);

			}

		});

	}

	function memberListAjaxHTML(p) {
		$.ajax({
			url : "/member/listAjaxHTML",
			method : "get",
			data : {
				page : p,
				pageSize : 5
			},
			success : function(data) {
				var html = data.split("$$$seperrator$$$");
				$("#memberList").html(html[0]);

				$(".pagination").html(html[1]);

			}

		});

	}
</script>

<body>
	<div class="row">
		tiles : memberList_content.jsp
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

					</tbody>


				</table>
			</div>

			<a class="btn btn-default pull-right"
				href="${pageContext.request.contextPath }/member/memberRegist">사용자
				등록</a>

			<div class="text-center">
				<ul class="pagination">

				</ul>

			</div>
		</div>
	</div>
</body>
</html>
