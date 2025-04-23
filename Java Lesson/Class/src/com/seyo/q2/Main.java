package com.seyo.q2;

public class Main {

	public static void main(String[] args) {
		Book book = new Book();
		
		book.title = "자바의 정석";
		book.author = "남궁석";
		book.printlnfo();

	}

}


//this 키워드 사용
//맴버 변수와 매개변수 이름이 같을 때 this를 사용해서 값을 구분하기
//this를 사용해 맴버 변수 초기화


//메인 메서드 다른 방법
// public static void main(String[] args){
//    Book.book = new Book("자바의 정석", "남궁성");
//    book.printinfo(); 