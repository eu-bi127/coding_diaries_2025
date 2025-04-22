package com.seyo.String;

public class q6 {

	public static void main(String[] args) {
		String s1 = new String("hello").intern();				
		String s2 = "hello";				
		System.out.println(s1 == s2);			

	}

}


//답 : true

//.intern()메서드 ????