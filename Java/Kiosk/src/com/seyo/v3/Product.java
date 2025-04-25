package com.seyo.v3;

public class Product {
	//변수: name은 제품의 이름을 저장하는 문자열 변수, price는 제품의 가격을 저장하는 정수형 변수.
	String name;
	int price;
	
	//오버로딩(overloading) : 함수이름이 같지만 매개변수의 갯수나 형만 달리해서 중복 추가하는 것.
	//여러 개의 생성자를 오버로딩하여 정의 하고 있음. 
	
	//생성자함수 - 그중에 매개변수 2개짜리
	Product(int price, String name){
		this.name = name;
		this.price = price;
	}
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	Product(String name){
		this.name = name;
//		this.price = 1000;
	}
	Product(){
		
	}
	
	//함수들
//	public static void main(String[] args) {
//		
//	}
	
	public void info() {
		System.out.println(name+" 가격:"+price+"원");
	}
	
}
