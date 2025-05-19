<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
	String id = request.getParameter("id");     //사용자가 HTML 폼에서 입력한 id, pw 값을 가져옵니다.
	String pw = request.getParameter("pw");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		int resultCount = st.executeUpdate("insert into member values('"+id+"','"+pw+"')");
		
	} catch (Exception e) {		
		e.printStackTrace();
	}	
	
	response.sendRedirect("index.html");    //회원가입 완료 → "메인 페이지"나 "로그인 화면"으로 이동. //DB 처리 완료 후 사용자에게 다른 페이지 보여주기.
%>
</body>
</html>