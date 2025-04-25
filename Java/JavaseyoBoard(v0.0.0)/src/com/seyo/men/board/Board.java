package com.seyo.men.board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
	ArrayList<Post> ps = new ArrayList<>();
	
	void run() {
		xx:while(true) {
			
			System.out.println("crud 1.쓰기 2.읽기 3.리스트 4.수정 5.삭제 e.프로그램 종료");
			String cmd = sc.next();
			switch(cmd) {
			//사용자가 "1"을 입력하면 게시물 작성을 위한 입력을 받음.
			//제목,본문,작성자를 입력받고, saveNO를 증가시켜 새로운 Post 객체를 생성한 후 ps 리스트에 추가함.
			case "1":                        
				System.out.println("쓰기");
				System.out.println("제목:");
				String title = sc.next();
				System.out.println("본문:");
				String content = sc.next();
				System.out.println("작성자:");
				String writer = sc.next();
				Post p = new Post(title,content,writer);
				break;
				
			case "2":
				System.out.println("읽기");
				break;
				
			case "3":
				System.out.println("리스트");
			
				//for 루프를 사용해 ps 리스트의 각 게시물에 접근하고, 제목, 내용, 작성자, 번호를 출력함
				for(int i=0;i<ps.size();i=i+1) {
					String t = ps.get(i).title;
					String c = ps.get(i).content;
					String w = ps.get(i).writer;
					System.out.println("제목: "+t+" 작성자: "+w);
				}
				break;
			case "4":
				System.out.println("수정");
				break;
			case "5":
				System.out.println("삭제");
				break;
			case "e":
				System.out.println("프로그램종료");
				break xx;
			}
		}
	}
}
