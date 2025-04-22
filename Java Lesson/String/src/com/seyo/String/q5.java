package com.seyo.String;

public class q5 {

	public static void main(String[] args) {
		String s1 = new String("java");			
		String s2 = new String("java");			
		System.out.println(s1 == s2);		

	}

}


//답 : false

//new String()은 항상 새 객체를 생성함 → 주소 다름 → == 결과는 false.


//문자열 비교를 할 때는 ==대신 equals()메서드를 사용하는 것이 좋음.
//equals()메서드는 두 문자열의 내용을 비교하여 동일한지 여부를 판단 --> sl.equals(s2)는 true가 된다.
