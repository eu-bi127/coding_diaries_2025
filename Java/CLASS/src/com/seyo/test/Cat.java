package com.seyo.test;

public class Cat {
	int age;
	String name;
	String hobby;
	
	void x() {
		
	}
	int y() {
		return 100;
	}
	int add(int a, int b) {
		int sum = a + b;
		return sum;
	}
	
	//js
	//생성자 함수 오버로딩 -- 생성자 함수를 여러개 만들 수 있다. 
	//생성자 함수 : 
	public Cat() {
		
	}
	public Cat(int age, String name, String hobby) {
		this.age = age;   //맴버함수, this안쓰면 age가 어떤 age인지 모르기에 그 구분으로 쓰는것.
		this.name = name; 
		this.hobby = hobby;
	}
	public Cat(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
}
