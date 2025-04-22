package com.seyo.String;

public class q3 {

	public static void main(String[] args) {
		String a = new String("world");			
		String b = new String("world");			
		System.out.println(a.equals(b));

	}

}


//답: true 

//equals()는 문자열의 내용을 비교하므로 값이 같으면 true. 주소와는 상관 없음.


//* ==연산자와 equals()메서드의 차이점.
//==연산자는 두 객체의 참조(메모리 주소)를 비교함. 즉, 두 객체가 동일한 메모리 위치를 가리키고 있는지를 확인함.
//equals()메서드는 두 객체의 내용을 비교함. 즉, 두 객체가 동일한 값을 가지고 있는지를 확인함.
