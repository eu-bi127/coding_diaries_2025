<%@page import="java.sql.ResultSet"%>          <!-- SQL 결과 조회 객체 -->
<%@page import="java.sql.Statement"%>          <!-- SQL 실행 객체 -->
<%@page import="java.sql.DriverManager"%>      <!-- DB 드라이버 로딩 및 연결 -->
<%@page import="java.sql.Connection"%>         <!-- DB 연결 객체 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jsp 언어는 java, 출력형식은 html, 인코딩은 utf-8 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">         <!-- 이 부분은 그냥 html로 출력되는 부분, 브라우저에 "게시판-리스트"라는 문구와,"홈으로 이동" 링크가 표시됨. -->
<title>게시판-리스트</title>

</head>
<body>
게시판-리스트
<a href="index.jsp">홈으로 이동</a>

<!-- 핵심 java 코드, DB 연결 시도 -->
<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");        
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		System.out.println("접속 잘됐음");
	} catch (Exception e) {		
		e.printStackTrace();
	}	
%>

</body>
</html>