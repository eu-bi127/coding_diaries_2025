<!-- 사용자가 해당 페이지를 몇 번째 방문했는지 추적 -->
<!-- 쿠키가 있으면 방문 횟수를 읽어 +1 한 값을 다시 쿠키로 저장 -->
<!-- 쿠키가 없으면 새로운 쿠키를 생성해서 방문 횟수를 1로 설정 -->

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
    // 사용자가 countCookie 쿠키를 가지고 있는지 여부를 추적할 변수
	boolean hasCookie = false;

    // 클라이언트가 전송한 모든 쿠키 배열을 받아옴
	Cookie [] cookies = request.getCookies();
	// 쿠키가 존재하면 반복문을 통해 모든 쿠키를 확인
	if(cookies!=null){
		for(int i=0; i<cookies.length; i++){
			// "countCookie"라는 이름의 쿠키가 있는지 확인
			if(cookies[i].getName().equals("countCookie")){
				hasCookie = true;  // 쿠키가 존재함을 표시
				
				// 쿠키에 저장된 방문 횟수 값을 문자열로 읽음
				String countString = cookies[i].getValue();
%>
                <!-- 쿠키 이름과 값을 사용자에게 출력 -->
				쿠키 이름: <%=cookies[i].getName() %>
				쿠키 값: <%=countString %>
				<br>
				<%=countString %> 번째 방문!
<%				

                //방문 횟수를 1 증가시켜 쿠키를 다시 생성
				//쿠키 갱신
				int count = Integer.parseInt(countString) + 1;
				// 새로운 값으로 쿠키 생성 (값을 +1한 상태)
				Cookie cookie = new Cookie("countCookie", count+"");
				// 클라이언트에게 새 쿠키 전송 (기존 쿠키 덮어쓰기)
				response.addCookie(cookie);				
			}
		}
	}
	
	// 만약 countCookie가 없다면 (최초 방문)
	if(hasCookie == false){
		// countCookie 쿠키를 생성하고, 값은 "1"
		Cookie cookie = new Cookie("countCookie", "1");
		
		// 쿠키의 유효시간 설정을 주석 처리 → 세션 쿠키 (브라우저 종료 시 사라짐)
		//cookie.setMaxAge(60);	// 초 단위. 1분
		
		// 응답에 쿠키 추가
		response.addCookie(cookie);
%>		
        <!-- 사용자에게 쿠키 이름과 값을 보여줌 -->
		쿠키 이름: <%=cookie.getName() %>
		쿠키 값: <%=cookie.getValue() %>
		<br>
		<%=cookie.getValue() %> 번째 방문!
		
<%		
        //초기값 1로 생성 후, 다음 방문을 위해 값 2로 업데이트된 쿠키도 전송
		cookie = new Cookie("countCookie", "2");
		response.addCookie(cookie);		
	}
	
%>
</body>
</html>


<!-- 실행 흐름 요약 -->
<!-- 1. 브라우저가 서버에 요청을 보냄. -->
<!-- 2. 서버는 클라이언트가 쿠키(countCookie)를 가지고 있는지 확인. -->
<!-- 3.  이미 있는 경우:
방문 횟수 값 가져옴 → +1 → 새로운 쿠키로 전송 → 방문 횟수 출력 -->
<!-- 4. 없는 경우 (첫 방문):
값이 "1"인 쿠키 생성 → 출력
이어서 값이 "2"인 쿠키도 미리 전송해 다음 방문 대비 -->