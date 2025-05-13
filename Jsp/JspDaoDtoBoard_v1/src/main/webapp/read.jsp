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
String no=request.getParameter("no");     // 클라이언트(사용자)로부터 전달받은 게시글 번호(no)를 파라미터로 받아옴. // URL 예시: read.jsp?no=5 → 이때 no 값은 "5"가 됨

Dao dao=new Dao();         // DB 접근 객체 생성. 게시글 정보를 DB에서 불러오기 위해 Dao 인스턴스를 만듦
Dto d=dao.read(no);        // Dao의 read() 메서드를 호출하여 해당 번호(no)의 게시글 정보를 DB에서 읽어옴.  // 결과는 Dto 객체(d)에 저장됨. Dto에는 글번호, 작성자, 제목, 내용 등이 들어있음.
%>

<%=d.no%>
<%=d.id%>
<%=d.title%>
<hr>
<%=d.text%>

<a href="del.jsp?no=<%=no%>">삭제</a>
<a href="edit.jsp?no=<%=no%>">수정</a>
<a href="list.jsp">리스트로</a>

</body>
</html>