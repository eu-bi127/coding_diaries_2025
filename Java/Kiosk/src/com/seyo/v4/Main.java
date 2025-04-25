package com.seyo.v4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Product> basket = new ArrayList<Product>();
		
		//자동임포트 단축키: ctrl+shift+o(영문자O)
		Scanner sc = new Scanner(System.in);
		
		Product p1 = new Product("아아",1000);
		Product p2 = new Product("뜨아",1500);
		Product p3 = new Product("오렌지쥬스",2000);
		
		String cmd;
		xx:while(true) {
			System.out.print("명령 입력[1.음료선택/2.디저트선택/e.프로그램종료]:");
			cmd = sc.next();
			switch(cmd) {
			case "1":
				yy:while(true) {
					//메뉴출력
					p1.info();
					p2.info();
					p3.info();
					
					System.out.println("[1.아아/2.뜨아/3.오렌지쥬스/x.이전메뉴로]");
					System.out.println("");
					cmd = sc.next();
					switch(cmd) {
					case "1":
						System.out.println("아아 선택됨");
						
//						Product x = new Product("아아",1000);
						basket.add(p1);
						
						break;
					case "2":
						System.out.println("뜨아 선택됨");
						break;
					case "3":
						System.out.println("오렌지쥬스 선택됨");
						break;
					case "x":
						System.out.println("이전 메뉴 이동");
						break yy;
					}
				}
			case "2":
				System.out.println("2번");   // 단순히 "2번"을 출력하는 기능만 구현되어 있다.(디저트 선택 기능은 추가되어야 할 부분)
				break;
				
			case "e":
				System.out.println("프로그램종료");
				
				int count = basket.size();   //basket.size()로 상품개수를 구하고, for루프를 통해 각 상품의 가격을 합산함.
				System.out.println("장바구니에 담긴 상품 갯수:"+count);
				
				int sum = 0;
				for(int i=0;i<basket.size();i=i+1) {
					sum = sum + basket.get(i).price;
				}
				System.out.println("계산하실 금액은 :"+sum+"원 입니다.");
				
				break xx;
			}
		}		
	}
}
