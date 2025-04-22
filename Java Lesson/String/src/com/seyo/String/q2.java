package com.seyo.String;

public class q2 {

	public static void main(String[] args) {
		String a = new String("world");			
		String b = new String("world");			
		System.out.println(a == b);		

	}

}



//답 : false

//new키워드를 사용하면 항상 새로운 객체가 메모리에 생성됨. 
//a와 b는 서로 다른 메모리 주소를 가리키게 된다.