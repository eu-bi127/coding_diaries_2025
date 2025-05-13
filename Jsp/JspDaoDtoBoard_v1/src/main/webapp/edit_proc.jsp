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
	Dto dto = new Dto(                            // 사용자가 수정 폼에서 입력한 제목과 내용을 가져와 Dto 객체를 생성
			request.getParameter("title"),        // 수정된 제목
			request.getParameter("text")          // 수정된 내용
			);
	Dao dao = new Dao();                          // Dao 객체 생성: DB 접근을 위해 필요
	dao.edit(dto,request.getParameter("no"));     // Dao의 edit 메서드를 호출하여 DB에 글을 수정 // 파라미터: 수정된 게시글 데이터(dto), 수정할 글 번호(request.getParameter("no"))
	response.sendRedirect("list.jsp");            // 수정 후 게시글 목록 페이지로 자동 이동 (리다이렉트)
%>

</body>
</html>