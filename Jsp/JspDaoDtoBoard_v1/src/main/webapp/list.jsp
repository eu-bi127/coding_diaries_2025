

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
</head>
<body>
글번호, 제목, 작성자<hr>
<%
Dao dao=new Dao();      // Dao 클래스 객체 생성. 데이터베이스에서 데이터를 가져오기 위한 준비
 
ArrayList<Dto> posts=dao.list();   // Dao의 list() 메서드를 호출하여 게시글 목록을 가져옴. 각 게시글은 Dto 객체로 표현됨

for(int i=0;i<posts.size();i=i+1){           // 게시글 목록을 반복문으로 출력. posts 리스트의 크기만큼 반복함
%>

<%=posts.get(i).no%>                                                       <%-- 현재 게시글의 번호(no)를 출력 --%>
<a href="read.jsp?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>     <%-- 현재 게시글의 제목(title)을 하이퍼링크로 출력. 클릭 시 해당 글의 no 값을 read.jsp로 넘김 --%>
<%=posts.get(i).id%>                                                       <%-- 현재 게시글의 작성자 ID를 출력 --%>
<hr>                                  

<%
}
%>
<a href="write.jsp">쓰기</a>     <%-- 사용자가 새 글을 작성할 수 있도록 write.jsp로 이동하는 링크 --%>

</body>
</html>

<!--Dto (Data Transfer Object) — 데이터 전달 객체 -->
<!--무엇? 데이터(예: 게시글 번호, 제목, 작성자 등)를 한 덩어리로 담기 위한 객체입니다.  -->
<!--왜씀? 여러 개의 값을 메서드 간에 편리하게 주고받기 위해.-->
<!--예를 들어 게시글 하나가 no, title, id, content 등을 가지고 있다면, 이걸 전부 따로 전달하지 않고 Dto 하나에 담아서 넘길 수 있음.-->

<!-- Dao (Data Access Object) — 데이터 접근 객체 -->
<!--무엇? DB와 실제로 연결해서 데이터를 CRUD(Create, Read, Update, Delete) 하는 클래스임.  -->
<!--왜씀? 데이터베이스 접근 로직을 별도 클래스로 분리하면, 코드가 깔끔하고 유지보수하기 쉬워집니다, 
비즈니스 로직과 DB 로직을 분리해서 개발자 간 협업도 수월해집니다 -->

<!-- 비유로 설명 -->
<!-- Dto는 택배 상자: 여러 정보를 담아서 한 번에 전달.  -->
<!-- Dao는 배달 기사: DB에서 데이터를 가져와서 Dto에 담아 사용자에게 전달. -->