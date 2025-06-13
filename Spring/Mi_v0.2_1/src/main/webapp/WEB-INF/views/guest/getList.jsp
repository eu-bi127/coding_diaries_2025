<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="cp" value="$"{pageContext.request.contexPath}"/>

<table>
    <tr>
        <td>글번호</td>
        <td>글내용</td>
    </tr> 

<c:forEach var="guest" items="${list}">
    <tr>
        <td>${guest.bno}</td>
        <td><a href="${cp}/guest/read?bno=${guest.bno}">${guest.btext}</a></td>
    </tr>
</c:forEach>

</table>

<a href="/guest/write">새글 쓰기</a>


</body>
</html>