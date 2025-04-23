package com.seyo.q4;

public class Student {
	 String name;
	    int score;

	    Student(String name, int score) {
	        this.name = name;
	        this.score = score;
	    }

	    void printInfo() {
	        System.out.println("이름: " + name + ", 점수: " + score);
	    }
}


//학생 객체 여러 개 만들기
//Student 클래스를 만들어 이름과 점수를 저장하고, 객체 배열을 만들어 3명의 학생 정보를 출력하시오.
//출력 예시:
//이름: 철수, 점수: 90
//이름: 영희, 점수: 85
//이름: 민수, 점수: 78