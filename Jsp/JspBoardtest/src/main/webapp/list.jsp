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
<link rel="stylesheet" href="common.css">
</head>
<body>
글번호 | 제목 | 글내용 | 작성자id
<hr>

<%
   try {
	   Class.forName("com.mysql.cj.jdbc.Driver");         //MySQL JDBC 드라이버 클래스를 로드, 이는 드라이버가 Java와 MySQL 간의 연결을 가능하게 해주는 역할을 함.
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");  //데이터베이스에 연결.
	   Statement st = con.createStatement();                            //SQL 문을 실행하기 위한 Statement 객체를 생성함.
	   ResultSet rs = st.executeQuery("select * from cat_board");     //SQL SELECT 쿼리를 실행하여 결과를 ResultSet 객체로 받음. //이 쿼리는 cat_board 테이블의 모든 행을 조회함.
	   while(rs.next()){                      //결과 집합(ResultSet)을 순회하며, 각 행의 데이터를 가져온다.
		   String num = rs.getString("num");
		   String title = rs.getString("title");
		   String content = rs.getString("content");
		   String id = rs.getString("id");
%>

		   <%=num %> <a href="read.jsp?num=<%=num %>"><%=title %></a> <%=id %><br>       <!-- 표현하는 -->
<%
	   }   //반복문이 끝났음을 의미.
   } catch (Exception e) {
	   e.printStackTrace();     //예외가 발생했을 때, 스택 트레이스를 콘솔에 출력하여 오류 내용을 확인함.
   }   
   
 %>
     <a href = "write.jsp">글쓰기</a><a href="index.jsp">[홈]</a> 
 
 </body>
 </html> 