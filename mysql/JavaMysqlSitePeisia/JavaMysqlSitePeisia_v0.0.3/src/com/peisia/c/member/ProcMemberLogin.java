package com.peisia.c.member;

import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcMemberLogin {

	/* 로그인 처리 */
	static private String cmd = "";
	static public String run() {
		Cw.wn("======== 로그인 =========");
		String id="";
		String pw="";
		while(true) {
			id=Ci.r("아이디");
			if(id.length()>0) {
				break;
			}else {
				Cw.wn("장난x");
			}
		}
		while(true) {
			pw=Ci.r("암호");
			if(pw.length()>0) {
				break;
			}else {
				Cw.wn("장난x");
			}
		}
		//id,pw 를 디비에 저장. ex. insert into member values('nyang','1234');
		if(Db.isProcLogin(id,pw)) {              //DB에 저장된 ID/PW와 사용자가 입력한 값이 일치하는지 검증하는 메서드임.
			//todo
			//로그인 처리
			return id;
		}else {
			//로그인 실패 처리
			Cw.wn("로그인 실패");
			return null;
		}
	}
}


           //내부적으로는 < SELECT * FROM member WHERE id='입력값' AND pw='입력값' > 같은 퀴리를 실행할 가능성이 높다.
           //결과처리: 1. true 반환시 -> 로그인 성공 -> 입력한 id 반환.
           //2. false 반환 시 -> 로그인 실패 -> "로그인 실패"메시지 출력 후 null 반환.
           
