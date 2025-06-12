package com.peisia.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Cat {
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String name;
	public int age;
	public ArrayList<String> hobby = new ArrayList<>();
	public ArrayList<SkillDto> skills = new ArrayList<>();
}
