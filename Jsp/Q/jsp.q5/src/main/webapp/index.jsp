

<%@page import="com.Cat.Cat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="error.jsp" %>   <!-- 이 설정을 했을때 에러 페이지 설정. --> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//Cat cat = new Cat();
	Cat cat = null;
	System.out.println("콘솔로찍기:"+cat.name);
%>

<%=cat.name %>

</body>
</html>