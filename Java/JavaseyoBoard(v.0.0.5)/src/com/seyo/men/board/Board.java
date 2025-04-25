package com.seyo.men.board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
	ArrayList<Post> ps = new ArrayList<>();
	int saveNo = 0;
	
	void run() {
		xx:while(true) {
			//todo
			//메뉴 선택하게 하기
			System.out.println("crud 1.쓰기 2.읽기 3.리스트 4.수정 5.삭제 e.프로그램 종료");
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
				saveNo = saveNo + 1;
				Post p = new Post(title,content,writer,saveNo);
				ps.add(p);
				break;
			case "2":
				System.out.println("읽기");
				//몇번글을 읽을지 물어보기
				System.out.println("몇번글을 읽을까요? :");
				cmd = sc.next();
				
				//해당 글을 찾기
				for(int i=0;i<ps.size();i=i+1) {
					Post post = ps.get(i);
					
//					int postNo = post.no;
//					String postStringNo = postNo + "";
					String postStringNo = post.no + "";
					
//					if(postStringNo == cmd) {
					if(postStringNo.equals(cmd)) {	//찾았다!
						//읽기(출력)
						System.out.println("글번호:"+post.no+" 글내용:"+post.content+" 작성자:"+post.writer);
					}
				}
				break;
			case "3":
				System.out.println("리스트");
//				for(int i=0;i<ps.size();i++)
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
				//수정 할 글 번호 입력받기
				System.out.println("몇번글을 수정할까요? :");
				cmd = sc.next();           //사용자가 입력한 값은 cmd변수에 저장됨.
				
				//해당 글 가져오기
				//for 루프를 사용하여 ps리스트에 저장된 모든 게시물(post 객체)를 순회한다.
				for(int i=0;i<ps.size();i=i+1) {  
					Post post = ps.get(i);                  //ps.get(i)를 통해 현재 인덱스 i에 해당하는 게시물 객첼을 가져옵니다
					String postStringNo = post.no + "";     //post.no는 게시물의 고유 번호임. 이걸 문자열로 변환해 postString에 저장함.
					if(postStringNo.equals(cmd)) {	
						//찾았다!
						//if조건문을 통해 사용자가 입력한 번호(cmd)와 현재 게시물의 번호(postStringNo)가 일치하는지 확인함. 일치하면 해당 게시물을 찾은 겁니다.
						
						//수정활 내용. 바꿀 내용 입력하기
						System.out.println("바꿀내용은? :");
						
//						String newContent = sc.next();
//						post.content = newContent;
						post.content = sc.next();	//새 내용을 덮어쓰기
						//sc.next()를 통해 사용자가 입력한 새 내용을 읽어와서 post.content에 저장함. 이때 기존의 내용은 덮어쓰게됨.
					}
				}					
				break;
			case "5":
				System.out.println("삭제");
				//삭제 할 글 번호 입력받기
				System.out.println("몇번글을 지울까요? :");
				cmd = sc.next();
				
				//글 리스트에서 삭제할 글 찾기
				int searchNo = 0;
				//해당 글을 찾기
				for(int i=0;i<ps.size();i=i+1) {
					Post post = ps.get(i);
					String postStringNo = post.no + "";
					if(postStringNo.equals(cmd)) {	//찾았다!
						//인덱스 i 를 기억해놓기
						searchNo = i;
					}
				}				
				//삭제
				ps.remove(searchNo);
				
				break;
			case "e":
				System.out.println("프로그램종료");
				break xx;
			}
		}
	}
}
