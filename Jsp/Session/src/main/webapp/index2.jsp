<!-- 이전 페이지에서 전달받은 "좋아하는 계절" 값을 읽음 -->
<!-- 세션에 저장된 사용자 ID를 꺼냄 -->
<!-- 둘을 이용해 개인화된 메시지를 출력 -->

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
	request.setCharacterEncoding("UTF-8");                 //POST 방식으로 전송된 데이터에서 한글이 깨지지 않도록 요청(request)의 인코딩을 UTF-8로 설정.

	String season = request.getParameter("season");        //이전 페이지(index.jsp 또는 index2.jsp)에서 전송된 season 값을 받아옴. //사용자가 선택한 계절(봄, 여름, 가을, 겨울 중 하나).
	String id = (String)session.getAttribute("idKey");     
	//사용자의 로그인 정보를 세션(session)으로부터 꺼내는 역할. 
	//getAttribute("idKey")는 세션에 저장된 값 중 "idKey"라는 이름으로 저장된 데이터를 꺼내는 메서드임.
	//왜 (String)으로 형변환 하나?
    //getAttribute()는 반환 타입이 Object이다. //JSP/Java에서는 Object를 다시 원하는 자료형으로 형변환(casting) 해야함.
    //이 값이 String 타입이라는 걸 알고 있으므로 (String)으로 형변환한다.
%>

	<%=id %>님이 좋아하는 계절은 <%=season %> 입니다.         


</body>
</html>



