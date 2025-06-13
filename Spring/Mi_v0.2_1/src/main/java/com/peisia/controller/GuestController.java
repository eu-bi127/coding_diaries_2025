package com.peisia.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dto.GuestDto;
import com.peisia.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
public class GuestController {
	
	private GuestService service;
	
	@GetMapping("/getList")
	public void getList(@RequestParam(value="currentPage", defaultValue="1") int currentPage, Model model) {
		model.addAttribute("list",service.getList(currentPage));
	}
	
	@GetMapping({"/read","/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러====글번호======"+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	@PostMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러===글번호====="+bno);
		service.del(bno);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	@PostMapping("/write")
	public String write(GuestDto gvo) {
		service.write(gvo);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	@GetMapping("/write")
	public void write() {
	
	}
	
	@PostMapping("/modify")
	public String modify(GuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList?currentPage=1";
	}
}
