<!--  Spring MVC + JSP + JSTL 조합에서 게시글 목록을 보여주는 JSP 뷰 파일 -->
<!--  JSP는 컨트롤러에서 전달받은 list 데이터를 HTML 테이블로 출력하며,
 게시글 내용을 클릭하면 상세 페이지로 이동할 수 있게 구성되어 있다. -->
 
 <!-- jsp의 주요 기능 -->
 <!-- 목록 출력 - 컨트롤러에서 전달한 게시글 리스트를 반복 출력 -->
 <!-- 상세 링크 연결 - 각 글을 클릭하면 read.jsp로 이동 -->
 <!-- JSTL사용 - JSP에서 JAVA코드를 최소화하고 forEach, set 등으로 처리 -->

<!-- 1. JSP 지시어 및 JSTL 선언 -->
<!-- taglib: JSTL의 core(제어문 if,forEach 그리고 변수설정 등)라이브러리를 사용하겠다는 선언 (반복, 조건 등)-->
<!-- import: Java List 관련 클래스 임포트 -->
<!-- contentType, charset: 한글 깨짐 방지를 위한 설정 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 2. JSTL로 contextPath 저장 --> 
<!-- 현재 웹 어플리케이션의 컨텍스트 경로를 ${cp} 변수에 저장 -->   
<!-- 예: http://localhost:8080/myapp → ${cp} = /myapp -->
<!-- 링크를 만들 때 앞에 붙여주면 경로 문제 방지 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->

<!-- 3. 게시물 목록 출력 -->
<table>
	<tr>
		<td>글번호</td>
		<td>글내용</td>
	</tr>
	
<!-- 4. forEach로 게시글 반복 출력 -->
<!-- jstl 로 처리하면 더 짧게 가능 -->
<c:forEach var="guest" items="${list}">
	<tr>
		<td>${guest.bno}</td>
		<td><a href="${cp}/guest/read?bno=${guest.bno}">${guest.btext}</a></td>
    </tr>
</c:forEach>
<!-- items="${list}": Controller에서 전달된 list를 반복, GuestDto 객체들이 들어 있음.  -->
<!-- var="guest": 반복마다 하나의 글 객체를 의미 -->
<!-- ${guest.bno}: 글 번호 출력, ${guest.btext}: 글 내용 출력 -->
<!-- <a href=...>: 글 제목 클릭 시 상세페이지로 이동 -->

</table>

<!-- 5. 새 글 작성 링크 -->
<a href="/guest/write">새글 쓰기</a>
<!-- 사용자가 글을 새로 쓸 수 있는 링크 -->
<!-- /guest/write → GuestController의 GET 방식 write() 메서드 매핑됨 -->

<%-- 예전 방식 --%>
<%-- <c:forEach var="guest" items="${list}"> --%>
<%--     <c:set var="bno" value="${guest.bno}" /> --%>
<%--     <c:set var="btext" value="${guest.btext}" /> --%>
<%--     ${bno} --%>
<%--     ${btext} --%>
<!--     <hr> -->
<%-- </c:forEach> --%>

</body>
</html>





<!-- Spring MVC (Model-View-Controller -->
<!-- 1. MVC란? : MVC는 애플리케이션을 Model, View, Controller의 세 가지 역할로 나누는 아키텍처 패턴 -->
<!-- Model  : 비즈니스 로직, 데이터 처리 담당 (예: DAO, Service 등)  -->
<!-- View   : 사용자에게 보여지는 UI (예: JSP, Thymeleaf) -->
<!-- Controller : 사용자 요청을 받아서 적절한 Model 호출 후, 결과를 View에 전달 -->

<!-- Spring MVC의 흐름 -->
<!-- 1. 사용자가 URL 요청 2. DispatcherServlet이 요청 수신 3. 적절한 Controller에 전달 -->
<!-- 4. Controller는 Service/Model 호출하여 처리 5. 처리 결과를 View로 전달  6. View는 사용자에게 화면 표시 --> 

<!-- 라이브러리란? -->
<!-- 라이브러리(Library)는 개발자가 자주 사용하는 기능들을 미리 구현해놓은 코드들의 모음. -->
<!-- 쉽게 말해, 필요한 기능을 직접 만들지 않고 가져다 쓰는 코드 꾸러미. -->
<!-- 우리가 프로그램을 만들 때 반복적으로 사용하는 기능들(예: 문자열 처리, 날짜 계산, 화면 출력 등)을 누군가가 잘 정리해 놓은 걸 "라이브러리"라고 부른다. -->