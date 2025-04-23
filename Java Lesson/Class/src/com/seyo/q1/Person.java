package com.seyo.q1;

public class Person {
	String name;
	int age;
	
	void introduce() {
		System.out.println("안녕하세요, 저는 " + name + "이고, 나이는 " + age + "살입니다.");
	}
}



//클래스 선언 연습
// 다음과 같은 정보를 저장할 수 있는 Person 클래스를 만들기.
// 이름 (name)
// 나이 (age)
// 출력 메서드 introduce() -> 예: "안녕하세요, 저는 홍길동이고, 나의는 20살입니다."


//String으로 문자 name. 문자열 타입의 필드.
//int로 숫자 age. 정수 타입의 필드.
//void: 메서드가 아무런 값을 반환하지 않을 때 사용함. 

//*반환타입: 메서드가 실행된 후 반환할 값의 데이터 타입을 저장함. 예를들어, int,String,boolean 등 다양한 데이터 타입을 사용할 수 있음.