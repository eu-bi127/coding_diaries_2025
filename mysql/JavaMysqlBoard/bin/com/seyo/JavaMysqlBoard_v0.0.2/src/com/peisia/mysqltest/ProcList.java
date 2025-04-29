package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcList {
	static public final int PER_PAGE = 3;

	static public void run() {
		int startIndex = 0;		// 현재 페이지의 첫 글 인덱스
		int currentPage = 1;	// 현재 페이지
		
		////	전체 페이지 수를 구하기	////
		int totalPage = 0;
		if(Db.getPostCount() % PER_PAGE > 0) {
			totalPage = Db.getPostCount() / PER_PAGE + 1;     //페이지수가 딱 떨어지지 않고 나머지가 남을 때
		}else {
			totalPage = Db.getPostCount() / PER_PAGE;         //페이지수가 딱 떨어질때 
		}
		
		Cw.wn("총 페이지 수:"+totalPage);
		
		String cmd;
		while(true) {
			cmd = Ci.r("페이지번호입력[이전 메뉴로:x]:");
			if(cmd.equals("x")) {
				break;
			}
			currentPage = Integer.parseInt(cmd);
			if(currentPage > totalPage || currentPage < 1) {        //사용자의 입력값이 존재하지 않는 페이지일 경우을 생각해서 조건문 넣어줌.
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요");                   //currentPage가 1보다 작거나(0은안됨), totalPage보다 큰 페이지수을 넣었을때.
				continue;
			}

			startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
			Disp.titleList();
			String sql = "select * from board limit "+startIndex+","+PER_PAGE;
			try {
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
