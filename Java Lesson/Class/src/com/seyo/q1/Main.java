package com.seyo.q1;

public class Main {

	public static void main(String[] args) {
		//Person 객체 생성 
		Person p = new Person();
	        p.name = "홍길동";  //이름과 나이를 매개변수로 전달.
	        p.age = 20;          
	        p.introduce(); // introduce 메서드 호출
		

	}

}


//Person 클래스를 이용해, 홍길동(20살) 객체를 생성하고 introduce()를 호출함.
//출력 예시 : 안녕하세요, 저는 홍길동이고, 나이는 20살입니다.
