package com.peisia.c.board; 

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;

public class Board {
	public static final String VERSION = "v0.0.1";
	public static final String TITLE = "고양이 게시판 (" + VERSION + ") feat. sm.ahn";
	public void run() {
		Disp.title();    
		ProcMenu.run();
	}
}


//VERSION이라는 상수를 정의하여 게시판의 버전을 나타낸다.
//TITLE이라는 상수는 게시판의 제목을 정의, VERSION 상수를 포함하여 동적으로 생성함.
// 이 제목은 "고양이 게시판(v0.0.1)feat.sm,ahn"과 같은 형식어로 됨.
//run이라는 메서드는 게시판 애플리케이션의 실행을 담당함.
//Disp.title() 메서드를 호출하여, 게시판의 제목을 화면에 출력함
//ProcMenu.run()메서들르 호출하여, 메뉴를 처리하는 기능을 실행함.

//Board 클래스는 게시판 애플리케이션의 기본 구조를 제공, 제목을 출력하고 메뉴를 실행하는 기능을 포함하고 있음. 