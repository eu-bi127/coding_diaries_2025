package com.seyo.For;

public class Main4 {

	public static void main(String[] args) {
		for(int i=1; i<=20; i++) {
			if(i%3==0) {
				System.out.println(i);
			}else {
				System.out.println("패스");
			}
		}

	}

}

//1부터 20까지 숫자 중 3의 배수만 출력
//3의 배수가 아닐 땐 "패스"라고 출력