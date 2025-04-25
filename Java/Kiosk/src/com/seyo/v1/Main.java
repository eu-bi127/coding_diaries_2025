package com.seyo.v1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("============================================");
		System.out.println("================= 고양이카페       ===========");
		System.out.println("============================================");
		//ctrl + shift + o(영문자). 자동 임포트.
		Scanner sc = new Scanner(System.in);
		String cmd;
		loop_a:      //라벨을 붙여놓음. "x"가 나오면 라벨 붙인 while문 전체가 break로 빠져나옴.
		while(true) {
			System.out.print("명령:");
			cmd = sc.next();
			switch(cmd) {
			case "1":
				System.out.println("1번명령");
				break;
			case "2":
				System.out.println("2번명령");
				break;
			case "x":
				break loop_a;
			}
		}
		System.out.println("프로그램 종료");

	}

}
