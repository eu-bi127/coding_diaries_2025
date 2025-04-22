package com.seyo.else3;

public class Main9 {

	public static void main(String[] args) {
		int temp = 8;
		
		if(temp >= 30) {
			System.out.println("더워요");
		}else if(temp >= 10 && temp <30) {
			System.out.println("괜찮은 날씨에요");
		}else {
			System.out.println("추워요");
		}
	}

}


//10도 이상 30도 미만, 두가지의 조건이 있을때 && 그리고를 사용해준다.
// &&는 그리고, ||는 또는이다.