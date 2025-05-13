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
    // 폼(form)에서 전달된 title, id, text 파라미터를 받아 Dto 객체 생성
	Dto dto = new Dto(
			request.getParameter("title"),   // 사용자가 입력한 제목
			request.getParameter("id"),      // 사용자가 입력한 작성자 ID
			request.getParameter("text")     // 사용자가 입력한 게시글 본문 내용
			);
	Dao dao = new Dao();         // 데이터베이스 접근을 위한 Dao 객체 생성
	dao.write(dto);              // Dao 클래스의 write() 메서드를 호출하여, 위에서 생성한 Dto 객체(게시글)를 DB에 저장
	response.sendRedirect("list.jsp");      // 게시글 작성 후, 게시글 목록 페이지(list.jsp)로 자동 리다이렉트 (페이지 새로고침 없이 이동)
%>

</body>
</html>