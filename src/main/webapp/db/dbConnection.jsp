<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 	
	// DB 작업에 필요한 객체
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null; // 쿼리문이 select인 경우 사용

	try {
		// 1.드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.DB 접속(connection 객체 생성)
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String userId = "bani";
		String password = "java";

		
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<20; i++){
		conn = DriverManager.getConnection(url, userId, password);
		conn.close();			
		}
		
		long endTime = System.currentTimeMillis();
		out.println("<h3>소요시간 : " +(endTime-startTime)+"ms</h3>");
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e2) {}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e2) {}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e2) {}
	}


%>
</body>
</html>