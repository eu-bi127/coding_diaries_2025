package com.seyo.rpc;

import java.util.Scanner;  //단축키 ctrl + shift + o 누르면 (자동으로 임포트)생기는 문법. 오류 없어짐. 
                           //사용자 입력을 받기 위해 Scanner클래스를 임포트한다. 

public class Main {
	public static void main(String[] args) {  //Java 프로그램의 시작점인 main 메서드를 정의한다.
		System.out.println("가위바위보 중에 하나 입력해주세요:"); //""안에 있는 메세지를 출력한다.
		
		Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 준비 1단계
		
		String userRpc = sc.next(); // 사용자 입력을 받기 위한 준비 2단계
		
		System.out.println("님이 낸것은:"+userRpc);  //사용자가 입력한 값을 출력한다.
		
		int r = (int)(Math.random() * 3 + 1);	// 1~6 까지 랜덤하게 뽑음
		System.out.println("주사위를 굴려 "+r+"이 나왔습니다.");
		
		String comRpc = "";  //랜덤 값 r에 따라 comRpc 변수에 컴퓨터의 선택을 저장한다.
		if(r == 1) {
			comRpc = "가위";
		} else if(r == 2) {
			comRpc = "바위";
		} else if(r == 3) {
			comRpc = "보";
		}
		
		System.out.println("컴퓨터가 "+comRpc+" 냈습니다.");  // 컴퓨터가 선택한 값을 출력한다.
		
		//todo
		//결과 판정 //결과를 저장할 result 변수를 초기화한다. 
		String result = "";
		
		if(userRpc.equals("가위")) {
			if(comRpc.equals("가위")) {
				result="비김";
			}
			if(comRpc.equals("바위")) {
				result="짐";
			}
			if(comRpc.equals("보")) {
				result="이김";
			}
		}
		if(userRpc.equals("바위")) {
			if(comRpc.equals("가위")) {
				result="이김";
			}
			if(comRpc.equals("바위")) {
				result="비김";
			}
			if(comRpc.equals("보")) {
				result="짐";
			}
		}
		if(userRpc.equals("보")) {
			if(comRpc.equals("가위")) {
				result="짐";
			}
			if(comRpc.equals("바위")) {
				result="이김";
			}
			if(comRpc.equals("보")) {
				result="비김";
			}
		}
		System.out.println("결과:"+result);  //최종 결과를 출력함.
	}
}
