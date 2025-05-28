<!-- 자바빈이란? -->
<!-- 순수한 JAVA 객체로, 웹 애플린케이션에서 데이터들 담고 이동시키는 용도로 사용 -->
<!-- Bean이라는 자바 클래스를 jsp에 연결하고, HTTP 요청으로 전달된 값을 그 자바빈에 저장한 뒤 다시 출력하는 구조 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 자바빈 객체 생성 또는 가져오기  -->
    <!-- id: jsp에서 사용할 이름 ,   class: 자바빈 클래스의 전체 패키지명,  scope:  현재 체이지 안에서만 사용-->
	<jsp:useBean id="test_bean" class="com.peisia.q23.Bean" scope="page" />

    <!--  HTTP 요청 파라미터 중 name이라는 이름이 있으면
		그 값을 test_bean 객체의 setName() 메서드로 전달-->
	<!-- 예: URL에 ?name=cat 이 있으면 setName("cat") 호출됨 -->
	<jsp:setProperty name="test_bean" property="name" /> <!-- name - cat -->
	<jsp:setProperty name="test_bean" property="number" />
	<!-- number 파라미터 값을 자바빈의 setNumber() 메서드에 전달
		예: ?number=3 이라면 setNumber(3) -->
	
	<!-- test_bean.getName() 값을 HTML로 출력 --% -->
	<jsp:getProperty name="test_bean" property="name" />
	<jsp:getProperty name="test_bean" property="number" />
	<!-- test_bean.getNumber() 값을 HTML로 출력 --% -->

</body>
</html>