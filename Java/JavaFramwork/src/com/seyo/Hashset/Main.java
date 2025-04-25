package com.seyo.Hashset;

import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("고양이");
		hs.add("고양이");
		hs.add("개");
		
		int size = hs.size();
		
		System.out.println(size);
		
		Iterator<String> it = hs.iterator();
		System.out.println("-while, next() 으로 꺼내기-");
		while(it.hasNext()) {
			String s1 = it.next();
			System.out.println(s1);
		}

	}

}


//HashSet
//순서 없는 집합, 중복저장이 안되서 꺼낼 때 다름

//이런식으로 꺼내야함
//Iterator<String> it = s.iterator();
//System.out.println("-while, next() 으로 꺼내기-");
//while(it.hasNext()) {
//	String s1 = it.next();
//	System.out.println(s1);


