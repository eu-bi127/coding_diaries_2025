package com.seyo.String;

public class q4 {

	public static void main(String[] args) {
		String s1 = "java";									
		String s2 = "java";									
		System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));									

	}

}


//답 : true

//Java에서 문자열 리터럴을 사용할 때, 동일한 문자열 리터럴은 동일한 객체를 참조하도록 최적화함.
//즉, "java"라는 문자열 리터럴이 메모리에 한 번만 생성되고, s1과 s2는 모두 동일한 객체를 참조함.
//System.identityHashCode() : ???
