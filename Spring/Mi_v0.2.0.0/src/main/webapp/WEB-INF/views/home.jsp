
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->
<h1>
	Hello world!  
</h1>


<P>  The time on the server is ${serverTime}. </P>

<a href="${cp}/test/getOnePlusTwo">1+2 결과 보러가기</a>

<a href="${cp}/guest/getList">방명록</a>

<a href="${cp}/guest/getList?currentPage=1">[방명록]</a>

<a href="${cp}/guest/read?bno=1">방명록 1번글 보기</a>

<a href="${cp}/weather/w">어제 날씨</a>

</body>
</html>
