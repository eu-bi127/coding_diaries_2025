package com.seyo.v3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//프로그램의 시작을 알리는 메세지를 출력함. 카페의이름과 구분선을 출력하여 사용자에게 시각적으로 구분된 정보를 제공함.
		System.out.println("============================================");
		System.out.println("================= 고양이카페       ===========");
		System.out.println("============================================");
		//ctrl + shift + o(영문자). 자동 임포트.
		//p1,p2는 이름이 먼저, 가격이 두번째. p3는 가격이 먼저, 이름이 두번째 매개변수로 전달된다.
		//이러한 차이는 Product 클래스의 생성자 정의에 따라 다르다.
		//클래스의 생성자는 여러 형태로 오버로딩(overloading) 될 수 있다.
		// 같은 이름의 생성자가 매개변수의 타입이나 개수에 따라 다르게 정의될 수 있다.
		Product p1 = new Product("아아",1000);
		Product p2 = new Product("뜨아",2000);
		Product p3 = new Product(5000,"마카롱");
		
		Scanner sc = new Scanner(System.in);  // 사용자로 부터 입력을 받을 준비
		String cmd;
		loop_a:
		while(true) {                         // 무한 루프 
			System.out.print("명령:[1.음료/2.디저트/e.종료]");
			cmd = sc.next();
			switch(cmd) {             //switch문을 사용해서 사용자가 입력한 명령문에 따라 다른 동작을 수행함.
			case "1":
				System.out.println("==================================");
				System.out.println("============= 음료 리스트    =======");
				System.out.println("==================================");
				p1.info();      //"1"을 입력하면, p1.info()와 p2.info()는 각각의 음료정보를 출력하는 메서드.
				p2.info();
				loop_b:         // 음료 선택 하위 루프
				while(true) {
					System.out.print("명령:[1.아아/2.뜨아/x.이전메뉴]");
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
					}
				}
				
				break;
			case "2":
				System.out.println("==================================");
				System.out.println("============= 디저트 리스트    =======");
				System.out.println("==================================");
				p3.info();			 //"2"를 입력하면 디저트 리스트를 출력, p3.info()를 호출하여 디저트 정보를 출력함.	
				break;
			case "e":              // 사용자가 "e"를 입력하면 메인 루프를 종료.
				break loop_a;
			}
		}
		System.out.println("프로그램 종료");       //종료될 때 출력되는 메세지.
	}

}
