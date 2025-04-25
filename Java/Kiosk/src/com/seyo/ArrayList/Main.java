package com.seyo.ArrayList;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//자동임포트 ctrl+shift+o(영문자O)
		//무슨 타입의 것들이 배열되었는지 양쪽에 적어줘야 한다. --->배열은x. 
		//Srting의 문자열의 타입들이 모여있음
		ArrayList<String> xx = new ArrayList<String>();
		
		//숫자 배열은 아래처럼 선언해서 쓰면 됨. ArrayList 생성.
		//ArrayList 객체 xx를 생성한다.
		//ArrayList는 크기가 동적으로 조정되며, 요소를 추가하거나 제거할 수 있다.
		ArrayList<Integer> aa = new ArrayList<Integer>();
		aa.add(1);
		
		xx.add("고양이");	//고양이가 들어감. index 0. 이제 1개. 
		xx.add("개");	//개가 들어감. index 1. 2개됨. 넣을때 마다 크기가 늘어남.
		xx.set(1, "강아지");	//개 자리에 강아지가 들어감. 
		xx.add("너굴맨");	//너굴맨이 들어감. index 2. 3개됨.
		xx.remove(2);	//index 2에 있는거 제거함. 자리도 없애는거라 이제 갯수 2개됨. 뺄때마다 크기가 줄어듬.
//		xx.clear();		//싹다 지움. 수량도 0됨.
		
		System.out.println("몇개?:"+xx.size()); //size도 맴버함수 //xx에 저장된 요소의 개수를 출력한다.
		
		for(int i=0;i<xx.size();i=i+1) {     
			System.out.println(xx.get(i));    //get은 빼서 쓸때 사용. 함수가 있어서 문법이 이렇게 되었을 뿐,
		}
		boolean hasCat = xx.contains("고양이");   //contains는 포함된걸 물음.
		if(hasCat == true) {                    //고양이 있으면 true이면 있음 뜨고, flaes면 없음 뜸.
			System.out.println("고양이 있음");
		}else {
			System.out.println("고양이 없음");
		}

	}

}
