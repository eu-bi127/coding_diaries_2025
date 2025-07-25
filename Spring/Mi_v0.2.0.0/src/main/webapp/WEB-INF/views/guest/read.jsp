<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.peisia.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->
<%
	GuestDto read = (GuestDto)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext();
%>	

글본문
글번호:<%=bno %>
글내용:<%=btext %>

<!-- [ ] 글삭제로 이동. 글번호를 넘겨야함. -->
<a href="${cp}/guest/del?bno=${read.bno}">글 삭제</a>
<!-- [ ] 글 수정으로 이동. 글번호를 넘겨야함. -->
<a href="${cp}/guest/modify?bno=${read.bno}">글 수정</a>
<!-- [ ] 글 리스트로 이동. -->
<a href="${cp}/guest/getList">글 리스트</a>

</body>
</html>