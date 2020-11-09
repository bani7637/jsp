<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring: Ajax</title>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		// 이벤트 등록
		$("#makeJsonBtn").on("click", function(){
			console.log("makeJsonBtn click");
			$("#jsonString").html("");
			// 1. json객체 생성
			var a = {userid : $("#userid").val(), usernm :$("#usernm").val()};
			
			// 2. 문자열로 변경
			$("#jsonString").html(JSON.stringify(a));
		});

		$("#callAjax").on("click",function(){

			//makeJsonBtn 클릭이벤트 강제 발생
			$("#makeJsonBtn").trigger("click");
			
			$.ajax({
				url : "/ajax/json",
				data : JSON.stringify({userid : $("#userid").val(), usernm :$("#usernm").val()}),
				method :"post",
				contentType :"application/json; charset=utf-8",
				dataType: $("#dataType").val(),   // 서버로부터 받기 희망하는 데이터 타입
				success : function(data){
					$("#respjsonString").html("");

					if($("#dataType").val()=="json")
						$("#respjsonString").html(JSON.stringify(data));
					else
						$("#respjsonString").html((new XMLSerializer()).serializeToString(data));
				}

			});

		});
	})
</script>
</head>
<body>
	
	전송 json :<div id="jsonString"></div>
	응답 json :<div id="respjsonString"></div>
	userid : <input type="text" id="userid" name="userid" value="brown"/><br>
	usernm : <input type="text" id="usernm" name="usernm" value="브라운"/><br>
	<select id="dataType">
		<option value="json">json</option>
		<option value="xml">xml</option>
	</select>
	<button type="button" id="makeJsonBtn">json 문자열 생성</button>
	<button type="button" id="callAjax">전송</button>
</body>
</html>