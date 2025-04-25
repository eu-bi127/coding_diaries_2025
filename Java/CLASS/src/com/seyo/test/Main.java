package com.seyo.test;

public class Main {				
	public static void main(String[] args) {   
		Cat kitty = new Cat(10,"키티","식빵굽기");
		
		Cat yaongi = new Cat();
		yaongi.age = 10;
		
		Cat norangi = new Cat(100,"노랑이");  // Cat의 이름을 동일하게 설정.
		
		int sum = norangi.add(1, 2);
		System.out.println(sum);
	}			
}				

