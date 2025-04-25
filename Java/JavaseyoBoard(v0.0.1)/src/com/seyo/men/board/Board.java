package com.seyo.men.board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
	ArrayList<Post> ps = new ArrayList<>();
	int saveNo = 0;      //게시물 번호를 저장하는 정수형 변수 //새로운 게시물이 추가될 때마다 이 번호가 증가하여 각 게시물에 고유한 번홀르 부여함.
	
	void run() {
		xx:while(true) {
			
			System.out.println("crud 1.쓰기 2.읽기 3.리스트 4.수정 5.삭제 e.프로그램 종료");  //CRUD(생성,읽기,업데이트,삭제)
			String cmd = sc.next();  
			switch(cmd) {
			case "1":
				System.out.println("쓰기");
				System.out.println("제목:");
				String title = sc.next();
				System.out.println("본문:");
				String content = sc.next();
				System.out.println("작성자:");
				String writer = sc.next();
				saveNo = saveNo + 1;            //제목,본문,작성자를 입력받고,saveNo를 1증가시킴.
				Post p = new Post(title,content,writer,saveNo);   //새로운 post 객체를 생성하고, 이를 ps리스트에 추가함.
				ps.add(p);
				break;
			case "2":
				System.out.println("읽기");
				break;
			case "3":
				System.out.println("리스트");
				
				for(int i=0;i<ps.size();i=i+1) {
					String t = ps.get(i).title;
					String c = ps.get(i).content;
					String w = ps.get(i).writer;
					int no = ps.get(i).no;
					System.out.println("글번호:"+no+"제목: "+t+" 작성자: "+w);
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
