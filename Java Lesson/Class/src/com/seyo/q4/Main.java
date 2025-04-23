package com.seyo.q4;

public class Main {

	public static void main(String[] args) {
		  Student[] students = {
		            new Student("철수", 90),
		            new Student("영희", 85),
		            new Student("민수", 78)
		        };

		        for (Student s : students) {
		            s.printInfo();
		        }

	}

}



//최고 점수 학생 찾기
// 학생 배열에서 최고 점수를 받은 학생의 이름을 출력해보기.
// 출력 예시:
// 최고 점수 학생: 철수
