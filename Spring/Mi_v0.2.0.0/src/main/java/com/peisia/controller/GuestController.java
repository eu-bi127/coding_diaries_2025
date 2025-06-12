//이 코드는 Spring MVC 구조에서 Controller 계층을 담당하는 클래스임.
//즉, 사용자의 웹 요청(HTTP 요청)을 받아서 처리하고, 그에 맞는 서비스 호출과 뷰 반환을 담당하는 역할임.

//HTTP 요청(HTTP Request)은 웹 브라우저(또는 앱 등 클라이언트)가 웹 서버에 정보를 요청하는 행위.
//즉, 사용자가 웹사이트에서 어떤 행동을 할 때마다 (예: 버튼 클릭, 페이지 이동, 글쓰기 등)브라우저가 HTTP 요청을 보내고, 
//서버가 그에 대한 **HTTP 응답(Response)**을 돌려주는 방식

//전체 구조
//웹브라우저 --요청(URL, 데이터)--> Controller -> Service -> Mapper -> DB/SQL 실행 (결과를 다시 Controller->View로 전달)
//GuestController는 이 중 사용자 요청을 처음으로 받는 진입점.


package com.peisia.controller;

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

@Log4j                                 //	log.info() 같은 로그 출력 기능을 제공
@RequestMapping("/guest/*")            //이 클래스의 모든 URL 앞에 **/guest/**가 prefix로 붙음
@AllArgsConstructor                    //Lombok이 모든 필드를 받는 생성자를 자동 생성 (→ DI에 사용됨)
@Controller                            //이 클래스가 Spring MVC에서 컨트롤러 역할을 한다고 등록
public class GuestController {
		
	private GuestService service;    //@AllArgsConstructor 덕분에 자동으로 생성자를 통해 주입됨, 이 필드를 통해 서비스 계층 메서드 호출 가능.
	
	@GetMapping("/getList")    //1. 게시글 목록       
	public void getList(@RequestParam(value="currentPage", defaultValue="1") int currentPage, Model model) {
		model.addAttribute("list",service.getList(currentPage));
	}
	//currentPage가 현재페이지, defaultaValue은 값이 없으면 1페이지로 간주.
	
	@GetMapping({"/read", "/modify"})    //2. 글 상세 보기 & 수정 폼 공통
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")   //3. 글 삭제
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		service.del(bno);
		return "redirect:/guest/getList?currentPage=1";	// 책 p.245 참고
	}
	
	@PostMapping("/write")   //4. 글  쓰기 처리 (POST)
	public String write(GuestDto gvo) {
		service.write(gvo);
		return "redirect:/guest/getList?currentPage=1";	// 책 p.245 참고
	}
	
	@GetMapping("/write")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {
		
	}
	
	@PostMapping("/modify")
	public String modify(GuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	
}
