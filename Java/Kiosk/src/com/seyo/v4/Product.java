package com.seyo.v4;

public class Product {
	//1.변수들
	String name;    //이름을 저장하는 문자열 변수
	int price;      //가격을 저장하는 정수형 변수
	
	Product(String xx, int yy){
		name = xx;
		price = yy;
	}
	
	//2.함수들 (메인 말고)
	void info() {
		System.out.println("상품명:"+name+" 가격:"+price);
	}
	
}
