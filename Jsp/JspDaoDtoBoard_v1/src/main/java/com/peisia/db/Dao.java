package com.peisia.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Dao {
	Connection con=null;
	Statement st = null;
	/* Dao 클래스 (Data Acceess Object)
	 * 데이터베이스에 접근하여 CRUD 작업을 처리하는 클래스.
	 */
	
	
	/* (1/5)삭제기능: 특정 글 번호(no)에 해당하는 게시글을 삭제 */
	public void del(String no) {
		try {
			////고정 1 (jdbc드라이버 로딩)
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			////고정 2 (DB 연결)
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////고정 3 (Statement 객체 생성)
			st=con.createStatement();
			
			//코딩하시오: //실제 삭제 sql 실행 
			String sql = String.format("delete from %s where b_no=%s"
					,Db.TABLE_PS_BOARD_FREE, no);   //테이블명과 글번호 조합
			st.executeUpdate(sql);   //sql 실행
			
		
			////고정 4
			st.close();
			////고정 5
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* (2/5)글쓰기 기능: 새 게시글을 DB에 저장 */
	public void write(Dto d) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();	// [고정-3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			insert into ps_board_free (b_title,b_id,b_text) values ('야옹','cat','aaa');
			String sql = String.format(                                                   //String.format()이라는 문자열 포맷팅 함수를 사용해서,insert sql 구문을 생성함. 
					"insert into %s (b_title,b_id,b_text) values ('%s','%s','%s')"
					,Db.TABLE_PS_BOARD_FREE, d.title,d.id,d.text);
			st.executeUpdate(sql);            //이 sql 명령을 DB에 실제로 실행시킴. 
			
			st.close();		// [고정-4]
			con.close();	// [고정-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* (3/5)글 읽기 기능: 글 번호에 해당하는 게시글 상세 정보 조회 */
	public Dto read(String no) {
		Dto post = null;
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();	// [고정-3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			String sql = String.format(
					"select * from %s where b_no=%s"
					,Db.TABLE_PS_BOARD_FREE, no);
			System.out.println("sql:"+sql);  // 디버깅용 출력
			
			ResultSet rs = st.executeQuery(sql);  // SQL 실행 → 결과집합 반환
			rs.next();  // 첫 행으로 이동 (단일 게시글만 조회하므로 next() 1번 호출)
			
			// 결과셋에서 데이터를 꺼내 Dto 객체로 생성
			post = new Dto(
					rs.getString("B_NO"),
					rs.getString("B_TITLE"),
					rs.getString("B_ID"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
			st.close();		// [고정-4]
			con.close();	// [고정-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;  // 조회된 게시글 정보 반환
	}	
	
	
	/* (4/5)글 리스트 : 글 목록 조회(전체 게시글 리스트 반환) */
	public ArrayList<Dto> list() {
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();	// [고정-3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			
			// 전체 게시글 조회 SQL
			String sql = String.format(
					"select * from %s"
					,Db.TABLE_PS_BOARD_FREE);
			System.out.println("sql:"+sql);   // 디버깅용 출력
			
			ResultSet rs = st.executeQuery(sql);   // 결과 집합 반환
			while(rs.next()) {				
				// 한 행씩 읽어서 Dto 객체 생성 후 리스트에 추가
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
			st.close();		// [고정-4]
			con.close();	// [고정-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}
	
	/* (5/5)글 수정 : 특정 글 번호에 해당하는 게시글의 제목, 내용 수정 */
	public void edit(Dto d,String no) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();	// [고정-3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			update ps_board_free set b_title='bb',b_text='bbbb' where b_no=4;
			String sql = String.format(
					"update %s set b_title='%s',b_text='%s' where b_no=%s"
					,Db.TABLE_PS_BOARD_FREE, d.title,d.text,no);
			st.executeUpdate(sql);
			
			st.close();		// [고정-4]
			con.close();	// [고정-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}