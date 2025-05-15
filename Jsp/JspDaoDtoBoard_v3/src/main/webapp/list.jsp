<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="list.css">
</head>
<body>
글번호, 제목, 작성자<hr>


<%

String pageNum=request.getParameter("page");     // 현재 몇 페이지인지 URL 파라미터로 받음 //1페이지면 =1이라고 표시됨. 
if(pageNum==null){
	pageNum="1";                                 // page 파라미터가 없으면 기본값은 1페이지
}

Dao dao=new Dao();         // DB 접근을 위한 Dao 객체 생성


int count = dao.getPostCount();	// 1. 전체 글 수 (EX)44가 들어감)  // 전체 글 수가 몇개 인지 알아야 페이지수 정함. 

//2. 총 페이지 수 구하기
int totalPage = 0;
if(count % 3 == 0){		//case1. 나머지가 없이 딱 떨어지는 경우  (한 페이지에 3개씩 출력한다고 가정)
	totalPage = count / 3;     //ex) 토탈 페이지 7 = 3식 뿌릴거야 (int값이랑 int 값을 나누면 결과가 int로 나옴  *int/int=int))
}else{					//case2. 나머지가 있어서 짜투리 페이지가 필요한 경우
	totalPage = count / 3 + 1;    //ex) 7 % 3 = 2... 1 나머지1일 남은 경우에 한 페이지를 더 만들어 준다. +1 
}



ArrayList<Dto> posts=dao.list(pageNum);     // 현재 페이지에 해당하는 게시글 목록 가져오기

for(int i=0;i<posts.size();i=i+1){          // 가져온 게시글 리스트만큼 반복 출력 //토탈페이지 3이라고 했으니깐, 3바퀴 돈다.
%>

<%=posts.get(i).no%>                                                     <!-- 글 번호 출력 -->
<a href="read.jsp?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>   <!-- 제목을 누르면 해당 글 보기로 이동 -->
<%=posts.get(i).id%>                                                     <!-- 작성자 ID 출력 -->
    <hr>
<hr>
<%
}
%>
<hr>



<%
//페이지 번호 링크 출력
for(int i=1;i<=totalPage;i=i+1){
%>

<a href="list.jsp?page=<%=i%>"><%=i%></a>     <!-- i번째 페이지로 이동하는 링크 생성 -->

<%
}
%>
<hr>
<fieldset id="link">
	<legend>링크</legend>
	<a href="write.jsp">쓰기</a>
</fieldset>
<hr>
<fieldset id="log">
	<legend>로그</legend>
전체 글 수: <%=count %><br>
전체 페이지 수: <%=totalPage %><br>
현재 페이지 번호: <%=pageNum %><br>
</fieldset>


</body>
</html>