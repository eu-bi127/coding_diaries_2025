package com.seyo.For;

public class Main8 {

	public static void main(String[] args) {
		String[] fruits = {"Apple", "Banana", "Cherry"};
		
		for(int i =0; i<fruits.length; i++) {
			System.out.println(i + ": " + fruits[i]);
		}

	}

}


//문자열 배열에 들어있는 단어를 인덱스와 함께 출력
//출력 예시:
//0:Apple
//1:Banana
//2:Cherry


//문자열 배열 String[]
//for(int i=0; i<fruits.length; i++) : i를 0부터 시작하여 배열의 길이(fruits.length)보다 작은 동안 반복함.
//.length하면 길이값이 나오는데 지금은 apple, banana, cherry 3개. 0,1,2.