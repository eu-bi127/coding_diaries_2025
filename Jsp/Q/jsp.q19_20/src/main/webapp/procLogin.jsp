<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    // 1. 클라이언트가 전송한 id, pw 파라미터 받기 (GET/POST 둘 다 가능)
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 2. JDBC 연결에 필요한 객체들 선언
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	// 3. 입력값 디버깅 출력 (서버 콘솔)
	System.out.println("id: "+id);
	System.out.println("pw: "+pw);
	try {	
		Class.forName("com.mysql.cj.jdbc.Driver");     // 4. MySQL JDBC 드라이버 로드
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");     // 5. MySQL DB에 연결 (DB: my_cat, 사용자: root, 비밀번호: root)
		System.out.println("성공");    // 연결 성공 메시지
		
		stmt=con.createStatement();     // 6. SQL 실행을 위한 Statement 객체 생성
		
		rs = stmt.executeQuery("SELECT * FROM member where id='"+id+"'");    // 7. DB에서 입력된 ID와 같은 레코드를 조회하는 SQL 쿼리 실행
		rs.next();         // 8. 결과 행을 커서로 이동 (1개의 행만 가져올 것으로 가정)
		String pwTemp = rs.getString("pw");      // 9. 해당 아이디의 비밀번호 가져오기
		System.out.println("pwTemp: "+pwTemp); 
		
		// 10. 사용자가 입력한 비밀번호와 DB의 비밀번호 비교
		if(pw.equals(pwTemp)){ 
			//로그인 성공 후
			System.out.println("로그인 성공");       
			
			//세션에 id 를 저장하기
			session.setAttribute("x", id);       // 11. 로그인 성공 시 세션에 사용자 ID 저장     
			
			
		} else {
			System.out.println("로그인 실패");
		}
		stmt.close();     // 12. 자원 정리 (연결 종료)
		con.close();
		
	} catch (SQLException e){	
		System.out.println("sql 익셉션:"+e);
	} catch (Exception e) {	
		System.out.println("익셉션:"+e);
	}	
	
    // 13. 로그인 성공/실패와 관계없이 index.html로 리디렉션
	response.sendRedirect("index.html");
%>
</body>
</html>