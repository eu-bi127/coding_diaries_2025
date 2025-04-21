package com.seyo.ifelseif;

public class Main6 {

	public static void main(String[] args) {
		int num = 0;
		
		if(num > 0 ) {
			System.out.println("양수입니다");
		} else if (num < 0) {
			System.out.println("음수입니다");
		} else {
			System.out.println("0입니다");
		}

	}

}



//마지막 else를, else if(num == 0)로 해줘서 "0입니다"를 출려할 수 도 있다.
