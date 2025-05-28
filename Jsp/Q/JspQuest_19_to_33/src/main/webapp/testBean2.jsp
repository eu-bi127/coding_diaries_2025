<!-- JavaBean을 jsp에서 세 가지 방법을 모두 사용함. -->
<!-- 1. <jsp:setProperty>로 파라미터 자동 매핑 -->
<!-- 2. <jsp:getProperty>로 값 출력 -->
<!-- 3. 스크립틀릿과 **EL (Expression Language)**로 자바빈 값 접근 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="test_bean" class="com.peisia.q23.Bean" scope="page" />

<!-- 요청 파라미터를 자동으로 자바빈의 프로퍼티에 매핑함 -->
<!-- 예: URL에 ?name=cat&number=1111 이 있으면
		    setName("cat"), setNumber(1111) 자동 호출됨 -->
	<jsp:setProperty name="test_bean" property="*" /> <!-- name = cat, nuber = 1111 이 한방에 들어감. 이 한줄로. -->
	
	<jsp:getProperty name="test_bean" property="name" />
	<jsp:getProperty name="test_bean" property="number" />
    <!-- 자바빈의 getName(), getNumber() 결과를 HTML에 출력함 -->

<hr>

<!-- 스크립틀릿(Scriptlet) 방식으로 출력 -->
<fieldset>
	<legend>일반 jsp 객체로 접근해서 찍기</legend>
	<%=test_bean.getName()%> <hr>
	<%=test_bean.getNumber()%> <hr>
</fieldset>

<!-- EL (Expression Language) 방식으로 출력 -->
<fieldset>
	<legend>q26. EL을 써서 출력</legend>
	EL로 찍기: ${test_bean.name} <hr>
	EL로 찍기: ${test_bean.number} <hr>
</fieldset>




</body>
</html>