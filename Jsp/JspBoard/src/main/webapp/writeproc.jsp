<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//이전 화면에서 post 방식으로 한글을 보낸경우
	//아래 인코딩 설정을 해줘야함
    //request.setCharacterEncoding("UTF-8");

    //폼에서 전달받은 입력값(제목, 내용, 작성자 id)을 변수에 저장.
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");     // JDBC 드라이버 로드 (MySQL용)
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");     // DB 연결: DB명은 my_cat, 사용자 ID와 비밀번호는 각각 root
		Statement st = con.createStatement();   // SQL 실행용 Statement 객체 생성
		String sql = String.format("insert into cat_board (title,content,id) values ('%s','%s','%s')",title,content,id);    // INSERT SQL 구문 작성 (입력받은 값들을 문자열 포맷으로 삽입)
// 		String sql = "insert into cat_board (title,content,id) values ('"
// 				+title
// 				+"','"
// 				+content
// 				+"','"
// 				+id
// 				+"')";
		System.out.println("==== 전송하려는 sql:" + sql);		  // 디버깅용으로 콘솔에 SQL 출력
		int resultCount = st.executeUpdate(sql);	// 글쓰기 sql 전송 // SQL 실행: insert 구문 실행 후 영향을 받은 행 수 반환 //성공 시 1
		if(resultCount == 1){                       // 실행 결과 확인 및 로그 출력
			System.out.println("==== 글쓰기 성공");
		} else {
			System.out.println("==== 글쓰기 실패");
		}
	} catch (Exception e) {		
		e.printStackTrace();
	}
	
	response.sendRedirect("list.jsp");	// 글리스트 화면으로 강제 이동
%>
