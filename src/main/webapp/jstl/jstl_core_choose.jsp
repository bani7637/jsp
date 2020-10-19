<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      request.setAttribute("name", "brown");
   %>
   <c:choose>
      <c:when test="${name == 'sally'}">sally</c:when>
      <c:when test="${name == 'james'}">james</c:when>
      <c:when test="${name == 'brown'}">james</c:when>
      <c:when test="${name == 'moon'}">moon</c:when>
   </c:choose>
</body>
</html>