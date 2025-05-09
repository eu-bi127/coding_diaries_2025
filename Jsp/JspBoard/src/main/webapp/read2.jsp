<!-- 글 가져오기 하드코딩 sql문을 url get방식을 통해 넘어온 num 값을 조합하게 처리 -->

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
<title>게시판 - 글읽기</title>
</head>
<body>
<hr>
<%
	String readNum = request.getParameter("num");	//url get방식으로 읽을 글 번호를 받아서 변수 저장.
	                                                 //request.getParameter("num")를 사용하여 uql에서 num파라미터 값을 받아옴.
	                                                 //예를 들어, URL이 read.jsp?num=3이라면 readNum 변수에 "3"이 저장됨.

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from cat_board where num="+readNum);	//sql문 조합.
		                               //st.executeQuery(): SQL 퀴리를 실행하여 cat_board 테이블에서 num 값에 해당하는 게시글을 조회함.
		                               //SQL 문은 num 값을 URL 파라미터로 받은 readNum을 통해 동적으로 조합됨. 
		rs.next();
		String num = rs.getString("num");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");

%>

		글번호:<%=num %><br>
		글제목:<%=title %><br>
		작성자id:<%=id %><br>
		글내용:<br>
		<%=content %> 
			
<%			
		
	} catch (Exception e) {		
		e.printStackTrace();
	}	
%>
</body>
</html>