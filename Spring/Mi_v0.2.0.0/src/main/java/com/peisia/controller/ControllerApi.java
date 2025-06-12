package com.peisia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.Cat;
import com.peisia.dto.SkillDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j					
@RequestMapping("/api/*")					
@AllArgsConstructor					
@RestController					
public class ControllerApi {					
	@GetMapping("/cat")				
	public Cat cat() {				
		Cat cat = new Cat("야옹이",7);			
		cat.hobby.add("식빵굽기");			
		cat.hobby.add("잠자기");	
		
		cat.skills.add(new SkillDto("할퀴기",2));
		cat.skills.add(new SkillDto("백덤블링",3));
		cat.skills.add(new SkillDto("달리기",5));
		
		return cat;			
	}				
}					