package com.seyo.String;

public class q7 {

	public static void main(String[] args) {
		String saved = "peisia";				
		String input = new String("peisia");				
		System.out.println(input == saved);			

	}

}


//답 : false

//peisia"는 리터럴이지만, new String("peisia")는 새 객체 생성 → 서로 다른 주소 → == 결과는 false.