package com.seyo.ifelseif;

public class Main5 {

	public static void main(String[] args) {
		int score = 75;
		
		if(score >=90 ) {
			System.out.println("A등급");
		} else if(score >= 80) {
			System.out.println("B등급");
		} else if(score >=70) {
			System.out.println("C등급");
		} else {
			System.out.println("F등급");
		}

	}

}

//마지막 else를 모조건 사용해야 하는건 아님.
//위에것들에서 다 제외된 것을 else로 사용할 수도 있고,
//아니면, else if를 사용해서 else if(score >=)로 지정해줄 수 도 있다.