<!--이 JSP 코드는 Spring Framework를 사용하는 웹 애플리케이션의 홈 페이지를 구성하는 뷰(View) 파일이다.  -->

<!-- 전체적인 구조 -->
<!-- JSP (Java Server Pages) 문법을 이용해 HTML 안에 Java 코드와 JSTL (JSP Standard Tag Library) 태그가 포함되어 있다. -->
<!-- 보통 Spring MVC 패턴의 컨트롤러 → 서비스 → 뷰(JSP) 흐름에서 이 JSP는 최종적으로 브라우저에 보여지는 뷰(View) 역할을 한다. -->

<!-- 요약 :  -->
<!-- 1. Spring MVC에서 컨트롤러가 데이터를 담아 전달해주면 이를 출력하고, -->
<!-- 2. 여러 기능 페이지로 이동할 수 있는 링크를 제공하며, -->
<!-- 3. JSTL을 사용해 동적 데이터를 쉽게 처리한다. -->

<%-- JSP 디렉티브 (맨 위) --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   <!-- 이 JSP는 자바 언어를 사용하고, HTML 형식이며 UTF-8 인코딩으로 설정되어 있다는 의미 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!-- STL(Core 태그 라이브러리)을 사용하겠다는 선언 -->
<!-- c:...으로 시작하는 JSTL 태그를 사용하려면 이 선언이 필요 -->
<%@ page session="false" %>
<!-- 세션을 사용하지 않겠다는 설정입니다. 불필요한 세션 객체 생성을 방지 -->


<%-- JSTL 태그 설명 --%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->
<!-- 현재 웹 애플리케이션의 컨텍스트 경로를 cp라는 변수에 저장 -->
<!-- 예: http://localhost:8080/myapp/에서 cp는 /myapp이 된다. -->
<!-- 이후 하이퍼링크 생성 시 경로 앞에 ${cp}를 붙여서 절대경로를 만들 수 있게 해준다. -->
<h1>
	Hello world!  
</h1>

<%-- 동적인 데이터 출력 --%>
<P>  The time on the server is ${serverTime}. </P>
<!-- Spring Controller에서 Model에 serverTime이라는 변수를 넣어줬을 경우, 그 값이 출력 -->
<!-- 예: model.addAttribute("serverTime", new Date()); -->


<%-- 하이퍼링크 설명 --%>
<!-- /test/getOnePlusTwo 라는 URL을 호출하여 컨트롤러에서 처리된 결과 페이지로 이동 -->
<a href="${cp}/test/getOnePlusTwo">1+2 결과 보러가기</a>

<!-- 방명록 목록을 가져오는 링크입니다. 두 번째는 특정 페이지 번호(1페이지)를 지정한 요청 -->
<a href="${cp}/guest/getList">방명록</a>

<a href="${cp}/guest/getList?currentPage=1">[방명록]</a>

<!-- 방명록에서 번호가 1번인 글을 읽는 요청입니다. bno=1은 게시글 번호를 의미 -->
<a href="${cp}/guest/read?bno=1">방명록 1번글 보기</a>

<!-- 날씨 관련 정보를 보여주는 컨트롤러 메서드로 이동하는 링크 -->
<a href="${cp}/weather/w">어제 날씨</a>


<a href="${cp}/api/cat">고양이</a>


</body>
</html>
