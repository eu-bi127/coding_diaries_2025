package com.seyo.else3;

public class Main10 {

	public static void main(String[] args) {
		int hour = 14;
		
		if(hour >=6 && hour <=12) {
			System.out.println("아침입니다");
		}else if(hour >=12 && hour<=18) {
			System.out.println("오후입니다");
		}else {
			System.out.println("저녁입니다");
		}

	}

}


//미만,이하 구분 잘 하기.