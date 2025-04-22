package com.seyo.string;

public class Main7 {

	public static void main(String[] args) {
		String gender = "";
				
	    if(gender.equals("M")) {
	    	System.out.println("남자입니다");
	    }else if(gender.equals("W")) {
	    	System.out.println("여자입니다");
	    }else {
	    	System.out.println("땡");
	    }

	}

}

 
// equals의 설명

//작음따옴표(')로 감싼 한개의 문자는 char 타입이지만, 큰따옴표(")로 감싼 여러개의 문자들을 문자열이라고 부름.
//문자열을 변수에 저장하고 싶다면 다음과 같이 String 타입을 사용해야 한다.
