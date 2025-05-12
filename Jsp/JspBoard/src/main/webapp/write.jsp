<%@page import="java.sql.ResultSet"%>   <%-- SQL SELECT 결과 처리를 위한 ResultSet 클래스 임포트 (현재는 사용되지 않음) --%>
<%@page import="java.sql.Statement"%>   <%-- SQL 실행을 위한 Statement 클래스 임포트 (현재는 사용되지 않음) --%>
<%@page import="java.sql.DriverManager"%>    <%-- DB 연결을 위한 DriverManager 클래스 임포트 (현재는 사용되지 않음) --%>
<%@page import="java.sql.Connection"%>        <%-- DB 연결 객체를 위한 Connection 클래스 임포트 (현재는 사용되지 않음) --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>                                <%-- JSP 페이지 설정: Java 사용, HTML 출력, UTF-8 인코딩 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">           <%-- HTML 내 문자 인코딩을 UTF-8로 설정 --%>
<title>게시판 - 글쓰기</title>        <%-- 브라우저 탭 제목 --%>
<link rel="stylesheet" href="common.css">   <%-- 외부 CSS 파일 연결 (스타일 적용용) --%>
</head>
<body>
<hr>                                <%-- 수평선 구분선 --%>

<!-- 글쓰기 폼. 사용자가 입력한 데이터는 writeproc.jsp로 전송됨 -->
<!-- 현재는 method="get"으로 되어 있는데, 글쓰기에는 보통 method="post"를 사용하는 것이 안전함 -->
<form action="writeproc.jsp" method="get">                       
	글제목:<input name="title"><br>                                  <!-- 제목 입력 필드 -->
	글작성자id:<input name="id"><br>                                  <!-- 작성자 ID 입력 필드 -->
	글내용:<textarea name="content" rows="5" cols="50"></textarea>   <!-- 본문 내용 입력 텍스트영역 (여러 줄 입력 가능) -->
	<input type="submit" value="글쓰기">                             <!-- 전송 버튼 -->
</form>


</body>
</html>