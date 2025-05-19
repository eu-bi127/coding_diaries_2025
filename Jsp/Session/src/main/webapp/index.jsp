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
	request.setCharacterEncoding("UTF-8");    //POST 방식일 경우 한글 깨짐 방지를 위해 요청 파라미터 인코딩을 UTF-8로 설정.

	String id = request.getParameter("id");   
	String pw = request.getParameter("pw");
	
	session.setAttribute("idKey",id);
	session.setMaxInactiveInterval(30);       //세션 유지 시간을 30초로 제한함. 이 시간이 지나면 세션이 만료됨.
	
%>

<form method="post" action="index2.jsp">             <!-- 선택 후 POST 방식으로 index2.jsp로 데이터를 전송 -->
	1.가장 좋아하는 계절은?<br>
	<input type=radio name="season" value="봄">봄      <!-- name="season"으로 설정했기 때문에 서버에서 request.getParameter("season")으로 값을 받을 수 있음. -->
	<input type=radio name="season" value="여름">여름
	<input type=radio name="season" value="가을">가을
	<input type=radio name="season" value="겨울">겨울
	<input type=submit>
</form> 


</body>
</html>

<!-- *요약* -->
<!-- 세션 처리 : 사용자 ID를 세션에 저장 (idkey) -->
<!-- 폼 입력 : 좋아하는 계절을 선택하여 index2.jsp로 전송 -->
<!-- 인코딩 : UTF-8로 설정하여 한글 지원 -->
<!-- 세션 유지 시간 : 30초로 제한 -->

