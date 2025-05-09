<!-- write.jsp에서 넘어온 글 데이터들을 db에 insert처리 -->

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//이전 화면에서 post 방식으로 한글을 보낸경우
	//아래 인코딩 설정을 해줘야함
// 	request.setCharacterEncoding("UTF-8");

//사용자가 폼에 입력한 제목, 내용, 작성자id를 request.getParameter() 메서드를 통해 HTTP 요청에서 받음.
// title, content, id 이 값들은 사용자가 POST 방식으로 폼을 제출 했을 때 서버로 전달됨. 
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");   // MySQL JDBC 드라이버를 동적 로딩하여 데이터베이스와 연결할 수 있게함.
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");   //MySQL 데이터베이스에 연결함.
		Statement st = con.createStatement();  //SQL 퀴리를 실행하기 위한 Statement 객페를 생섬함.
		String sql = String.format("insert into cat_board (title,content,id) values ('%s','%s','%s')",title,content,id);
// 		String sql = "insert into cat_board (title,content,id) values ('"
// 				+title
// 				+"','"
// 				+content
// 				+"','"
// 				+id
// 				+"')";
		System.out.println("==== 전송하려는 sql:" + sql);		
		int resultCount = st.executeUpdate(sql);	// 글쓰기 sql 전송
		if(resultCount == 1){
			System.out.println("==== 글쓰기 성공");
		} else {
			System.out.println("==== 글쓰기 실패");
		}
	} catch (Exception e) {		
		e.printStackTrace();
	}
	
	response.sendRedirect("list.jsp");	// 글리스트 화면으로 강제 이동
%>
