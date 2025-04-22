package com.seyo.String;

public class q1 {

	public static void main(String[] args) {
		String a = "hello";		
		String b = "hello";		
		System.out.println(a == b);

	}

}


//String 비교
//true인가 false인가

//답 : true

//true인 이유는 java에서 문자열 리터럴(String literals)이 어떻게 처리되는지와 관련있다.
//1. 문자열 리터럴의 저장 : Java에서는 문자열 리터럴을 사용할 때, 동일한 문자열 리터럴은 동일한 메모리 위치에 저장된다.
//즉, String a = "hello"와 String b = "hello":는 두 개의 서로 다른 변수를 가리키고 있지만, 두 변수 모두 같은 문자열 리터럴 "hello"를 창조함.
//2. ==연산자 : ==연산자는 두 객체의 참조(메모리주소)를 비교함. 
//따라서 a == b 는 두 변수가 같은 메모리 주소를 가리키고 있는지 확인함.
//a와 b는 모두 같은 문자열 리터럴 "hello"를 가르키므로, a==b는 true이다.