<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
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
String no=request.getParameter("no");

Dao dao=new Dao();
Dto d=dao.read(no);
%>

<%=d.no%>
<%=d.id%>
<%=d.title%>
<hr>
<%=d.text%>

<a href="/board/del?no=<%=no%>">삭제</a>    <!-- /슬러쉬가 있으면 절대경로 -->
<a href="edit.jsp?no=<%=no%>">수정</a>      <!-- 없으면 상대경로 -->
<a href="list.jsp">리스트로</a>


</body>
</html>