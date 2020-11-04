<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- client form method : post // enctype="multipart/form-data" -->
	<!-- server - servlet : @MultipartConfig
				  spring  :  multipartResolver
	 -->
	<form action="${pageContext.request.contextPath}/Fileupload/fileupload" method="post" enctype="multipart/form-data">
		userid : <input type="text" name="userid" value="brown"/> <br>
		파일 : <input type="file" name="realFilename"/>	
		<button type="submit" >등록</button>
	</form>
</body>
</html>