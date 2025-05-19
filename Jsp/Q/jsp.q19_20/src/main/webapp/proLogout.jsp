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
    //session.invalidate();기능 : **현재 사용자의 세션을 완전히 종료(무효화)**,세션 안에 저장되어 있던 모든 데이터가 사라짐.
	session.invalidate();	//"x" << "cat" 저장했던게 날아감. 보안적으로 좋음.
	response.sendRedirect("index.html");  //클라이언트(브라우저)에게 다른 페이지로 이동하라고 지시함. 로그아웃 처리가 끝났다는 사실을 사용자에게 알려주기 위해.
	
%>



</body>
</html>