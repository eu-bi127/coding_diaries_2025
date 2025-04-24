package com.seyo.mysqlB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProcBoard {
	Connection con = null;   //데이터베이스와 연결을 관리하는 객체.
	Statement st = null;     //sql퀴리를 실행하는 객체.  statement를 사용해 퀴리를 실행하고, 실행된 결과를 반환받을수 있다.
	
	

	void run() {       //프로그램의 동작을 실행하는 메서드. 다음 작업을 순차적으로 실행함.
		dbInit();     //데이터베이스에 연결하고, statement 객체를 초기화한다.
		dbExecuteUpdate("insert into board (b_t"
				+ "itle,b_id,b_datetime,b_text,b_hit) values ('콘솔프로그램에서쓴글','kitty',now(),'콘솔프로그램에서 작성한 글입니다. 글글.....글....',0)");
	}
	//board 테이블에 데이터를 삽입하는 Insert 퀴리를 실행함.
	
	
	//dbInit()는 메서드는 데이터베이스에 연결을 설정하는 메서드. 이 메서드는 2가지 주요 작업을 처리함.
	private void dbInit() {
		try {
			// (1/n) 디비 접속 정보 넣어서 접속하기
			//1. 데이터베이스 연결: 
			//DriverManager.getConnection() 메서드를 사용하여 MYAQL 데이터베이스에 연결함.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
	    	//localhost는 현재 컴퓨터를 의미, 3306은 MYSQL의 기본 포트이다. my_cat은 연결할 데이터베이스 이름이다.
			
			// (2/n) Statement 객체 얻어오기.
			//2. statement 객체 생성:
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		
		//try-catch 블록을 사용하여 예외를 처리함. 
	    //데이터베이스 연결이나 statement 객체 생성중에 발생할 수 있는 예외를 처리하고, 발생한 예외의 상세 정보를 출력함.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	            //dbExecuteUpdate()메서드는 전달된 sql 퀴리문을 실행하는 역할을 함.
	            // 주로 Insert, Update, Delete와 같은 데이터베이스를 수정하는 작업에 사용함. 
	private void dbExecuteUpdate(String query) {
		try {
			// (3/n) Statement 객체의 executeUpdate함수에 sql문 실어서 디비에서 실행되게 하기
			//query는 실행할 sql 퀴리 문자열임.
			//executeupdate() 메서드는 sql 퀴리를 실행하고, 영향을 받은 행의 수를 반환한다.
			//예를 들면, Insert 퀴리를 실행한면 삽입된 행의 수가 반환된다.
			int resultCount = st.executeUpdate(query); // 이거 하는 순간 디비에 sql(쿼리) 날아감. (디비에 반영됨)
			
			//resultCount는 퀴리 실행 결과를 데이터베이스에 반영된 행의 수이다.
			System.out.println("처리된 행 수:"+resultCount); //퀴리 실행 후 영향을 받은 행 수를 출력함.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}




//전체 흐름
//1. run() 메서드가 호출되면, 프로그램은 먼저 dbInit() 메서드를 통해 MySQL 데이터베이스에 연결하고 Statement 객체를 준비합니다.

//2. 그런 다음 dbExecuteUpdate() 메서드를 통해 INSERT 쿼리를 실행하여 board 테이블에 데이터를 삽입합니다.

//3. 데이터베이스에 반영된 행 수가 콘솔에 출력됩니다.

