<!-- 폼 태그만 작성함,  액션은 writeproc.jsp -->

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
<title>게시판 - 글쓰기</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<hr>

<!-- <form>: 사용자가 입력한 데이터를 서버를 전송하는 HTML 폼을 정의함.  -->
<!-- action = "writeproc.jsp" : 폼이 제출될 때 데이터를 처리할 jsp 페이지인 writeproc.jsp로 데이터를 전송함. -->
<!-- method = "get": Get 방식으로 데이터를 전송함. 이 방식은 데이터를 URL의 퀴리 스트링에 포함시켜 전송함. -->
<form action="writeproc.jsp" method="get">  
	글제목:<input name="title"><br>       <!-- 글 제목 -->
	글작성자id:<input name="id"><br>       <!-- 글 작성자 ID -->
	글내용:<textarea name="content" rows="5" cols="50"></textarea>    <!-- 글 내용 -->
	<input type="submit" value="글쓰기">            <!-- 제출버튼: 사용자가 폼을 제출할 수 있는 버튼임. 버튼을 클릭하면 폼의 데이터가 writeproc.jsp로 전송됨. -->
</form>


</body>
</html>



<!-- Get방식은 Http 요청 방식 중 하나로, 주로 웹 브라우저에서 서버로 데이터를 요철할 떄 사용. -->
<!-- GET 방식의 개념 - GET은 "데이터를 요청하는"방식이다. 즉, 서버에 데이터를 요청하는데 사용되며, 데이터를 URL에 포함시켜 서버로 보냅니다. -->
<!-- URL 퀴리 스트링: GET 방식에서는 데이터를 URL의 퀴리스트링에 포함시켜 보냄. 퀴리스트링은 URL 뒤에 ?로 시작하며, &로 구분된 key=value 형식의 파라미터들이 붙음. -->
<!-- 예시,  http://example.com/search?keyword=apple&category=fruits -->
<!-- URL에서는 keyword라는 파라미터에 "apple" 값이, category 파라미터에 "fruits" 값이 포함되어 서버로 전송됨. -->