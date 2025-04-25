package com.seyo.rpg;

public class MainD {
	public static void main(String[] args) {
		Dice x = new Dice();
		
		int r = x.roll(6);
		
		System.out.println(r);
	}
}