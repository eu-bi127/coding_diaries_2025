package com.seyo.For;

public class Main5 {

	public static void main(String[] args) {
		int sum = 0;   //합계를 저장할 변수 초기화
		
		// 1부터 5까지 반복
		for (int i=1; i<=5; i++) {
			sum += i;  // 현재 i값을 sum에 더함 
		}
		// 최종 합계 출력
		System.out.println("합계:"+sum);
	}

}


//1부터 5까지 합을 출력
//단, 중간값은 출력하지 말고 최종 합만 출력
//문자열 "합계:" 와 같이 sum값 나옴

//i++ ---> i = i+1와 동일.
//sum = sum + i; ----> sum + = i;와 동일.
