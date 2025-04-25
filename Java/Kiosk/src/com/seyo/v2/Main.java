package com.seyo.v2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("============================================");
		System.out.println("================= 고양이카페       ===========");
		System.out.println("============================================");
		//ctrl + shift + o(영문자). 자동 임포트.
		Scanner sc = new Scanner(System.in);
		String cmd;
		loop_a:                  //라벨
		while(true) {            //전체 설정
			System.out.print("명령:[1.음료/2.디저트/3.x]");
			cmd = sc.next();
			switch(cmd) {
			case "1":
				System.out.println("1번");
				
				loop_b:                 //라벨
				while(true) {           // 1번 메뉴 설정
					System.out.print("명령:[1.아아/2.뜨아/x.이전메뉴/e.프로그램 종료]");
					cmd = sc.next();					
					switch(cmd) {
					case "1":
						System.out.println("아아가 1개 선택됐습니다.");
						break;
					case "2":
						System.out.println("뜨아가 1개 선택됐습니다.");
						break;
					case "x":
						break loop_b;
					case "e":
						break loop_a;
					}
				}
				
				break;
			case "2":
				System.out.println("2번명령<개발중입니다>");
				break;
			case "x":
				break loop_a;
			}
		}
		System.out.println("프로그램 종료");

	}

}
