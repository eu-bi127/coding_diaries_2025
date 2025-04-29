package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcList {                     //목록만 보여주는 역할
	static public final int PER_PAGE = 3;   //한 페이지에 보여줄 글 개수는 3개.

	static public void run() {
		int startIndex = 0;		// 현재 페이지의 첫 글 인덱스 (가져올 시작 위치)
		int currentPage = 1;	// 현재 페이지 
		
		String cmd;
		while(true) {
			cmd = Ci.r("페이지번호입력[이전 메뉴로:x]:");    //사용자로부터 페이지 번호를 입력받음.
			if(cmd.equals("x")) {                   //x입력시 루프 종료 -> 이전 메뉴(또는 메인)로 돌아가는 구조.
				break;                              
			}
			currentPage = Integer.parseInt(cmd);    //입력된 페이지 번호를 정수로 변환하여 currentpage에 저장. 

			startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
			Disp.titleList();                           //Disp.titleList();는 글 목록 상단의 "번호|제목|작성자|시간"같은 라벨을 출력함
			String sql = "select * from board limit "+startIndex+","+PER_PAGE;
			try {	//todo
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
			
		}
		


	}
}
