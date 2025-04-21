package com.seyo.For;

public class Main9 {

	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			if (i%3==0) {
				System.out.println("Fizz");
			}else if (i%5==0) {
				System.out.println("Buzz");
			}else if (i%3==0 && i%5==0) {
				System.out.println("FizzBuzz");
			}else {
				System.out.println(i);
			}
		}

	}

}


//1부터 100까지 중에서
//3의 배수면 "Fizz"
//5의 배수면 "Buzz"
//둘 다면 "FizzBuzz"
//그 외엔 숫자 그대로 출력

