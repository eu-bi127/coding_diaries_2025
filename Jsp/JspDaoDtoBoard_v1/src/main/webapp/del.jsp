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
	String no=request.getParameter("no");     // 요청(request)에서 "no" 파라미터를 받아옴   // 예: del.jsp?no=5 → no = "5"
	Dao dao = new Dao();                      // 데이터베이스에 접근하기 위한 Dao 객체 생성
	dao.del(no);                              // Dao의 del() 메서드를 호출하여 해당 글 번호(no)의 게시글을 DB에서 삭제
	response.sendRedirect("list.jsp");        // 삭제 작업이 끝난 후, 게시글 목록 페이지로 리다이렉트(자동 이동)시킴 // 사용자는 삭제 후 리스트 페이지로 이동됨
%>

</body>
</html>