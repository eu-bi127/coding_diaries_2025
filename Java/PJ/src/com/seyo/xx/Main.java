package com.seyo.xx;

// 주석임
/* 여러줄 주석임 */
public class Main { // 접근제한자 public . 클래스임을 표시하는 키워드 class. 클래스이름인 Main (첫 대문자 주의. 해당 파일이름도 Xxx.java
					// 로 똑같아야 함 주의)

	// 이게 자바의 함수임. 멤버 함수 맞음. 단, 이 main 함수는 특수 함수임.
	// 이 main 함수부터 코드 실행 흐름이 시작됨.
	// 각 키워드들은 일단 무시하시고 그냥 복붙해서 쓰거나 main 이라고 타이핑 하고 ctrl + space 하면 vsc 에밋 기능처럼 코드
	// 자동완성되니 이걸 이용하시오.

//	main치고 ctrl + space

// pyblic static~~라는 형태로 하나라도 들어가야지 실행이 가능함.
// 메인에서 프로그램이 첨 실행시킨다.
 //Java 프로그램의 진입점이다. 프로그램이 실행될 떄 가장 먼저 호출되는 메서드이다.
 //String[]args는 명령줄 인수를 받을 수 있는 매개변수이다.	
	public static void main(String[] args) {
		int a = 1;   // 정수형 변수a를 선언하고 1로 초기화한다.
		System.out.println(a);    //변수a의 값을 콘솔에 출력한다. 이 경우, 출력 결과는 1이다.

		Cat cat1 = new Cat(); // 객체 생성. 이제 총 3개의 Cat 객체가 각각 생성되었다.
		Cat cat2 = new Cat();
		Cat cat3 = new Cat();

		cat1.info(); // 객체의 run 함수 실행. 
		// cat1객체의 info 메서드를 호출함. 이 메서드는 Cat 클래스에 정의되어 있어야하며, 객체의 정보를 출력하는 기능함.

		cat2.name = "키티";
		cat2.age = 10;

		cat2.info();
        // cat2객체의 info메서드를 호출하며, cat2의 정보를 출력함.
		// cat2의 name과 age 속성을 포함한 정보를 출력한다.
	}
}