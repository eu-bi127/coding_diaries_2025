<!-- 서버에서 클라이언트로 쿠키를 설정(굽는)하는 예제 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        <!--JSP 페이지 설정: Java 언어 사용, UTF-8 인코딩  -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>   <!-- 브라우저 탭에 표시될 제목  -->
</head>
<body>

<% 
    //cookieA라는 이름의 쿠기 생성, 값은 "Apple"
	Cookie cookieA = new Cookie("cookieA", "Apple");
    //cookieA의 수명을 10초로 설정 (10초 후 자동 삭제됨)
	cookieA.setMaxAge(10);	// 초 단위. 1분
	//cookieA.setValue("Melone");
	//쿠키를 응답에 추가해서 클라이언트(브라우저)로 전송
	response.addCookie(cookieA);
	
	// cookieX라는 이름의 쿠키 생성, 값은 "Grape"
	Cookie cookieX = new Cookie("cookieX", "Grape");
	//cookieX의 수명을 30초로 설정
	cookieX.setMaxAge(30);	// 초 단위. 1분
	response.addCookie(cookieX);
	
	Cookie cookieEternal = new Cookie("cookieEternal", "안썩는쿠키");
// 	cookieX.setMaxAge(30);	// 초 단위. 1분
// cookieEternal--> 유효 기간을 따로 설정하지 않음 → 브라우저를 닫으면 쿠키가 사라짐 (세션 쿠키)
	response.addCookie(cookieEternal);
%>

<!-- 사용자에게 메시지 출력 -->
쿠키 구웠음<br>

<!-- 쿠키 확인하러 이동하는 링크 제공  -->
쿠키 내용은 <a href="tasteCookie.jsp">여기로!!!</a>


</body>
</html>



