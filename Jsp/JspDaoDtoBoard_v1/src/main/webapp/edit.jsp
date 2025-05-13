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
//글번호 no가 get 방식으로 넘어 왔다고 가정
String no = request.getParameter("no");      // 글 번호(no)가 URL을 통해 GET 방식으로 넘어왔다고 가정. // 예: edit.jsp?no=3 → no = "3"
//글 가져오기
Dao dao = new Dao();                         // Dao 객체 생성 → DB 연결 및 조작 담당
Dto dto = dao.read(no);                      // 해당 글 번호로 DB에서 글 내용(Dto)을 가져옴
%>



<form action="edit_proc.jsp">                              <%-- 수정된 데이터를 처리할 페이지인 edit_proc.jsp로 전송할 폼 --%>
	<input type="hidden" name="no" value="<%=no%>">        <%-- 글 번호는 사용자가 수정하면 안 되므로 hidden 필드로 전달 --%>
	<input name="title" value="<%=dto.title%>">            <%-- 현재 제목을 입력창에 미리 넣어줌 (수정 가능) --%>
	<input name="text" value="<%=dto.text%>">              <%-- 현재 본문 내용을 입력창에 미리 넣어줌 (수정 가능) --%>
	<input type="submit" value="수정">                       <%-- 수정 완료 버튼 클릭 시 edit_proc.jsp로 데이터 전송 --%>
</form>
<a href="list.jsp">리스트로</a>                               <%-- 글 목록 페이지로 돌아가는 링크 --%>
</body>
</html>