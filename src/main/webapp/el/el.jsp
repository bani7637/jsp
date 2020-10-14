<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/el" method="post">
	<% String scope =request.getParameter("scope");
	   String requestParam ="";
	   String sessionParam ="";
	   String applicationParam ="";
	   if(scope !=null)
	   if(scope.equals("requestValue"))
		   requestParam = "checked";
	   else if(scope.equals("sessionValue"))
		   sessionParam = "checked";
	   else if(scope.equals("applicationValue"))
		   applicationParam = "checked";
	   else
		   requestParam ="checked";
	%>
		request(request)                           :  <input type="radio" name ="scope" value="requestValue" <%= requestParam %>/><br> 
		session(request, session)                  :  <input type="radio" name ="scope" value="sessionValue" <%= sessionParam %>/><br> 
		application(request, session, application) :  <input type="radio" name ="scope" value="applicationValue" <%= applicationParam %>/><br>
		<button type="submit">전송</button>
	</form> 
	attr : ${attr}(page -> request -> session ->application)<br> 
	requestScope : ${requestScope.attr}<br>
	sessionScope : ${sessionScope.attr}<br>
	applicationScope : ${applicationScope.attr}<br><br>
	
	param : ${param.scope}<br><br>
	
	cookie : ${cookie.userid.value}<br><br>
	
	map(rangers.brown) : ${rangers.brown}<br>
	map(rangers.sally) : ${rangers.sally}<br><br>
	
	list[인덱스], list[인덱스].속성 :<br>
	list[0] : ${rangersList[0]}<br>
	list[0].속성(userid) : ${rangersList[0].userid}<br>
	list[0].속성(pass) : ${rangersList[0].pass}<br>
	
	
	
</body>
</html>