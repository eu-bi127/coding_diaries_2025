<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원 전용 서비스를 하는 페이지~~</h1>

<%
	String id = (String)session.getAttribute("x");    //현재 로그인한 사용자의 ID를 세션에서 꺼내는 코드. "x"라는 이름의 데이터를 꺼냄.

	if(id == null){
		response.sendRedirect("index.html");
	}
    //세션에서 id를 가져왔을 때 null이라면 로그인하지 않은 상태. 
    //그 경우엔 index.html로 리디렉션(redirect)한다.
    //리디렉션 뜻 : 
    //서버가 브라우저에게 "다른 페이지로 이동하라"는 명령을 보내는 것.
    //로그인하지 않은 사용자가 이 페이지를 직접 열려고 할 경우 자동으로 로그인 페이지나 홈으로 돌려보냄.
    //즉, 이 구문은 비로그인 사용자 차단 기능입니다.
%>



<%= id %> 회원님 환영해요~



</body>
</html>



