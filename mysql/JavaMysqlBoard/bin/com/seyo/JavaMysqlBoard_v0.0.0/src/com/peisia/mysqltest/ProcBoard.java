package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcBoard {
	static public final int PER_PAGE = 3;

	int startIndex = 0;		// 현재 페이지의 첫 글 인덱스
	int currentPage = 1;	// 현재 페이지
	void run() {
		Disp.showTitle();
		Db.dbInit();
		loop:while(true) {
			Db.dbPostCount();
			Disp.showMainMenu();
			String cmd=Ci.r("명령입력: ");
			switch(cmd) {
			case "1":	//글리스트
				//currentpage(:현재페이지번호) ex)currentpage=1 ->첫번째 페이지  currentpage=2 ->두번째 페이지
				//PER_PAGE(:페이지당 글 수) ex)PER_PAGE=3 ->한페이지에 글 3개 출력, PER_PAGE=10 ->글10개출력
				//왜 필요하나? 데이터가 너무 많을 때, 적당히 나눠서 보여줘야 사용자에게 보기 좋고, 성능에도 좋기 때문임.
				//startIndex(:가져올 글의 시작 위치) ->sql에서 LIMIT문의 첫 번째 인자에 사용됨.
				//계산식 --> startIndex = (currentPage - 1) * PER_PAGE;
				//ex)currentPage = 1, PER_PAGE = 3  --> (1 - 1) * 3 = 0  (0번 인덱스부터 3개 가져오기)
                //ex)currentPage = 2, PER_PAGE = 3 --> (2 - 1) * 3 = 3      (3번 인덱스부터 3개 가져오기)
				//sql에서는 SELECT * FROM board LIMIT 3, 3; 이런식으로 가져오기 떄문. -> 3번 인덱스(즉, 4번째 글)부터 3개 가져온다는 의미.
				startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
				Disp.titleList();
				try {	//todo
					String sql = "select * from board limit "+startIndex+","+PER_PAGE;
					Cw.wn("전송한sql문:"+sql);
					Db.result = Db.st.executeQuery(sql);
					while(Db.result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
						String no = Db.result.getString("b_no");
						String title = Db.result.getString("b_title");
						String id = Db.result.getString("b_id");
						String datetime = Db.result.getString("b_datetime");
						Cw.wn(no+" "+title+" "+id+" "+datetime);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "2":	//글읽기
				String readNo = Ci.r("읽을 글 번호를 입력해주세요:");
				try {
					Db.result = Db.st.executeQuery("select * from board where b_no ="+readNo);
					Db.result.next();	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
					String title = Db.result.getString("b_title");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					String content = Db.result.getString("b_text");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					Cw.wn("글제목: "+title);
					Cw.wn("글내용: "+content);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "3":	//글쓰기
				String title = Ci.rl("제목을 입력해주세요:");
				String content = Ci.rl("글내용을 입력해주세요:");
				String id = Ci.rl("작성자id를 입력해주세요:");
				try {
					Db.st.executeUpdate("insert into board (b_title,b_id,b_datetime,b_text,b_hit)"
							+" values ('"+title+"','"+id+"',now(),'"+content+"',0)");
					Cw.wn("글등록 완료");
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				break;
			case "4":	//글삭제
				String delNo = Ci.r("삭제할 글번호를 입력해주세요:");
				Db.dbExecuteUpdate("delete from board where b_no="+delNo);
				break;
			case "5":	//글수정
				String editNo = Ci.r("수정할 글번호를 입력해주세요:");
				String edTitle = Ci.rl("제목을 입력해주세요:");
				String edId = Ci.rl("작성자id를 입력해주세요:");				
				String edContent = Ci.rl("글내용을 입력해주세요:");
				Db.dbExecuteUpdate("update board set b_title='"+edTitle+"',b_id='"+edId+"',b_datetime=now(),b_text='"+edContent+"' where b_no="+editNo);
				break;
			case "0":	//관리자
				break;
			case "e":	//프로그램 종료
				Cw.wn("프로그램종료");
				break loop;
			}
		}
	}
}