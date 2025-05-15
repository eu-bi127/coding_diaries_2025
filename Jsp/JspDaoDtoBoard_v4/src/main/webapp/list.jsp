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
String pageNum=request.getParameter("page");
if(pageNum==null){
	pageNum="1";
}
Dao dao=new Dao();
int totalPage = 0;
ArrayList<Dto> posts = null;
String searchWord=request.getParameter("word");
if(searchWord==null||searchWord.equals("null")){	// case1. 검색어가 없으면!!  (실제로 검색어가 없는 상태를 정확히 판별)
	posts=dao.list(pageNum);                                //해당 페이지의 전체 게시글 목록을 불러옴. 
	totalPage = dao.getTotalPageCount();					//총 페이지 수 구하기( 전체 게시글 수를 기준으로 페이지 수 계산.)(ex. 총 32개 게시글, 한 페이지당 10개 - > 총 4페이지)
}else{												// case2. 검색어가 있으면!!
	posts=dao.listSearch(searchWord,pageNum);
	totalPage = dao.getSearchTotalPageCount(searchWord);	//총 페이지 수 구하기
}

for(int i=0;i<posts.size();i=i+1){
%>

<%=posts.get(i).no%>
<a href="read.jsp?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>
<%
}
for(int i=1;i<=totalPage;i=i+1){
%>
<a href="list.jsp?page=<%=i%>&word=<%=searchWord%>"><%=i%></a>
<%
}
%>
<form action="list.jsp">
	<input name="word">
	<input type="submit" value="검색">
</form>
<hr>
<fieldset id="link">
	<legend>링크</legend>
	<a href="write.jsp">쓰기</a>
	<a href="list.jsp">list로</a>
</fieldset>
<hr>
<fieldset id="log">
	<legend>로그</legend>
전체 페이지 수: <%=totalPage %><br>
현재 페이지 번호: <%=pageNum %><br>
</fieldset>
</body>
</html>