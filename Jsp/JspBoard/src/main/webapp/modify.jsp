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
<title>게시판 - 글수정</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<hr>
<%
	String editNum = request.getParameter("num");        // URL에서 수정할 글 번호(num) 값을 파라미터로 받음
	// 글 제목, 내용, 작성자 ID를 저장할 변수 초기화
	String title = null;
	String content = null;
	String id = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		String sql = "select * from cat_board where num="+editNum;        // 특정 글 번호에 해당하는 게시글 데이터를 조회하는 SQL 작성
		System.out.println("==== 전송하려는 sql:" + sql);		// 실행할 SQL을 콘솔에 출력 (디버깅용)
		ResultSet rs = st.executeQuery(sql);	// SQL 실행 결과 받아오기, 해당 글을 데이터베이스에서 조회 // 수정 할 글 하나 읽기 sql 전송
		rs.next();	// 글 선반에서 글 하나 꺼내서 작업대에 올리기. // 결과 셋에서 한 줄만 가져오기 (글 하나만 해당하므로 rs.next() 한 번만 호출)
		// 가져온 결과에서 각 칼럼 값을 변수에 저장
		title = rs.getString("title");
		content = rs.getString("content");
		id = rs.getString("id");
		
	} catch (Exception e) {		
		e.printStackTrace();
	}
 %>

글번호:<%=editNum %><br>

<form action="modifyproc.jsp" method="get">
	<input name="num" type="hidden" value=<%=editNum%>>
	제목:<input name="title" value="<%=title %>"><br>
	내용:<textarea name="content" rows="5" cols="40"><%=content %></textarea><br>
	작성자id<input name="id" value="<%=id %>"><br>
	<input type="submit" value="글수정하기">    <!-- 폼 제출 버튼, submit를 써줘서 입력값들이 전송 -->
</form>


</body>
</html>