package com.seyo.rpc2;

public class Main {
	public static void main(String[] args) {    //String[] args:프로그램 실행 시 전달되는 인수들을 담는 배열.
		Rps rps = new Rps();
		rps.run();  //Rps 클래스의 run메서드를 호출하여 게임을 실행함. 게임의 주요 로직을 처리하는 역할. 
	}
}


//Rps 클래스는 이 코드에서 중요한 역할을 한다. 
//Rps 클래스를 사용해서 가위 바위 보 게임의 로직을 구현하고
//사용자 입력을 처리하며
//게임의 결과를 판별하는 기능을 포함할 것.
