package com.seyo.rpc2;

import java.util.Scanner;   //사용자 입력을 받기 위해 Scanner 클래스

public class Rps {
	void run() 	{           //void run():이 메서드는 반환값이 없으며,가위 바위 보 게임의 주요 로직을 처리한다.
		Scanner sc = new Scanner(System.in);  //사용자 입력을 받기 위한 Scanner 객체를 생성함.
		int r = 0;                            //컴퓨터의 선택을 저장할 변수이다.
		String cmd = "";                      //사용자의 입력을 저장할 변수이다.
		String result = "";                   //게임 결과를 저장할 변수이다.
		
		xx:
		while(true) {
			System.out.println("가위바위보 내! [종료=x] :");
			cmd = sc.next();
			r = (int)(Math.random() * 3 + 1);	//1~3
			switch(cmd) {              //사용자의 입력에 따라 게임 결과를 결정하는 switch문이다. 
			                           //switch를 쓰면 전의  if에서의 equals를 안써도됨.
			case "가위":
				switch(r) {
				case 1:
					result = "비김";
					break;
				case 2:
					result = "짐";
					break;
				case 3:
					result = "이김";
					break;
				}
				break;
			
			case "바위":
				switch(r) {
				case 1:
					result = "이김";
					break;
				case 2:
					result = "비김";
					break;
				case 3:
					result = "짐";
					break;
				}
				
				break;
			case "보":
				switch(r) {
				case 1:
					result = "짐";
					break;
				case 2:
					result = "이김";
					break;
				case 3:
					result = "비김";
					break;
				}
				
				break;
				
			case "x": //"x"는 그냥 삭제라는 의미로 줄여서 x로 쓴거일뿐.
				break xx; //xx라벨 붙여서 전체에서 빠져 나가는 거.
				
				//사용자가 "x"를 입력하면 break xx:를 통해 무한 루프를 종료함.
				
				// 라벨이라는 기능으로 
				// 위에 xx: 라고 표시(라벨)을 하면 
				// 바로 밑의 while문 (for도 가능함) 에 라벨이 매겨지게 되고
				// break 나 continue 문 사용 시 뒤에 라벨명을 붙이면
				// 자신을 감싼 가장 까가운 반복문 또는 switch 문경우
				// switch 문에서의 break 가 아닌 while 문의 break로 작동하게 됨.
		
			}
			System.out.println(result);
			//todo 양쪽 뭐 냈는지 표시하면 더 좋공..
		}
		System.out.println("프로그램 종료");    //루프가 종료된 후 프로그램 종료 메시지를 출력한다.
	}
}
