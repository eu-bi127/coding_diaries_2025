//Spring Framework에서 공공 기상청 API로부터 JSON 데이터를 받아와 처리하는 예제.
//전체 코드의 핵심은 JSON을 받아서 자바 객체로 변환하고, 원하는 필드를 꺼내서 출력(log)하는 것임. 
//목적 : 공공 API에서 JSON 형식의 날씨 데이터를 가져와 로그에 출력.

package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.Cat;
import com.peisia.dto.KWeatherDto;

import lombok.extern.log4j.Log4j;

//1. 클래스 선언부
@Log4j                            //로그 출력을 위한 롬복 어노테이션 (log.info() 쓸 수 있게 해줌)
@RequestMapping("/weather/*")     // /weather/로 시작하는 URL 요청 처리
//@AllArgsConstructor 
@Controller                       //Spring MVC 컨트롤러로 등록
public class WeatherController {

//2. 메서드 선언
	// /weather/w URL로 요청이 들어오면 이 메서드가 실행됨.
	// 주로 테스트용 또는 간단한 응답 테스트에 사용.
	@RequestMapping("/w")							
	public void w() {			
		//3. API 호줄 준비
		//// 우리나라 공공 api ////						
		//인코딩 인증키
		//String API_KEY = "인증키 (URL 인코딩된 형태)"  //String API_URL = "...JSON&serviceKey=" + API_KEY
		//기상청 API 호출 URL 구성. ---> 여기서 dataType=JSON이 중요 → JSON 형식으로 응답 받음.
		String API_KEY = "P3pnTHUpd0D8v9JDyUz8JpHuzGISR0t%2FECCOL5JNF1D2Rv%2Brd7DEMIRJBiqZwCPLSidP7NrtJZhzq0gMTp%2FEgg%3D%3D";						
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20230220&endDt=20230220&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey=" + API_KEY;						
				// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.				
		RestTemplate restTemplate = new RestTemplate();		
		//RestTemplate을 이용해 실제 HTTP GET 요청
								
		//// **** 중요 **** uri	
		//4. URI 객체 생성
		URI uri = null; //java.net.URI 임포트 하셈						
		try {						
			uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌					
		} catch (URISyntaxException e) {						
			e.printStackTrace();					
		}						
		
		//5. REST 호출 - 문자열 응답
		//응답 데이터를 문자열(String) 형태로 받아 로그로 출력 -> 원시 JSON 텍스트를 확인할 수 있음
		String s = restTemplate.getForObject(uri, String.class); //						
		log.info("====== 우리나라 날씨 잘 나오나? "+s);	
		//6. JSON -> JAVA 객체 매핑
		//KWeatherDto는 JSON 구조와 일치하는 Java 클래스여야 함
		//JSON을 자동으로 Java 객체로 매핑 (Jackson 라이브러리 사용)
		KWeatherDto kw = restTemplate.getForObject(uri, KWeatherDto.class); // 자기 클래스로 바꾸시오..									
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);									
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);	
		//7. 값 추출 및 출력
		//kw에서 원하는 데이터(지역명, 최저기온, 최고기온)를 꺼냄
		//String.format()으로 문장 구성
		//로그로 결과 출력
		String location = kw.response.body.items.item.get(0).stnNm;									
		String tMin = kw.response.body.items.item.get(0).minTa;									
		String tMax = kw.response.body.items.item.get(0).maxTa;									
		String ddara = String.format("==== json ==== : 어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location, tMin, tMax);									
		log.info(ddara);									
	}							
	   @RequestMapping("/getCat")                     
	   public void getCat() {                     
	      //// 우리나라 공공 api ////                  
	      //인코딩 인증키                  
	      String API_URL = "http://localhost:8080/api/cat";                  
	      // * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.            
	      RestTemplate restTemplate = new RestTemplate();                  
	      
	      //// **** 중요 **** uri                  
	      URI uri = null; //java.net.URI 임포트 하셈                  
	      try {                  
	         uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌               
	      } catch (URISyntaxException e) {                  
	         e.printStackTrace();               
	      }                  
	      
	      String s = restTemplate.getForObject(uri, String.class); //                  
	      log.info("====== 내 고양이 api 요청으로 받은 json 문자열 잘 나오나? "+s);   
	      
	      Cat catDto = restTemplate.getForObject(uri, Cat.class); // 자기 클래스로 바꾸시오..      
	      log.info("==== json ==== : 고양이 이름 잘 나오냐? : "+catDto.name);      
	      log.info("==== json ==== : 고양이 나이 잘 나오냐? : "+catDto.age);
	      log.info("==== json ==== : 고양이 취미 잘 나오냐? : "+catDto.hobby.get(0));
	      log.info("==== json ==== : 고양이 취미 잘 나오냐? : "+catDto.hobby.get(1));
	   }   
}




//*JSON 구조*
//최상단: [ ... ] → 배열 (복수의 응답 가능)
//그 안에 response 객체 → 응답 상태 + 실제 데이터
//그 안에 body → 날씨 관련 정보
//items.item → 여러 날씨 데이터 (날짜별 혹은 시간별)

//*위의 코드들 요약 정리, 단계
//1. URL 구성 - API 키 포함해서 요청 URL 완성
//2. URI 변환 - 안전한 호출 위해 문자열 → URI
//3. API 호출 - RestTemplate.getForObject() 사용
//4. JSON 문자열 로그 출력 -	응답이 잘 오는지 확인용
//5. DTO로 매핑(한 쪽 데이터를 다른 한쪽 형식에 맞게 대응시켜 연결함) - JSON 구조와 맞는 Java 클래스 필요
//6. 데이터 꺼내기 -	 원하는 필드만 뽑아 메시지로 출력

//*API란?
//API = Application Programming lnterface
//즉, 프로그램끼리 서로 소통할 수 있게 해주는 약속된 방법
//ex) 날씨앱 - 앱은 기상청 서버에 날씨 정보를 요청한다 "서울 오늘 날씨 좀 알려줘" -> 기상청은 JSON으로 응답함.
//-> 기상청이 외부에 제공하는 이 요청/응답 체계가 바로 기상청 API

//#API는 왜 중요할까?
//재사용성: 남이 만든 기능을 쉽게 이용할 수 있어요. (지도, 결제, 로그인 등)
//표준화: 약속된 방식으로 소통하므로 유지보수가 쉬워요.
//보안: 내부 시스템을 다 보여주지 않고, 필요한 기능만 외부에 공개해요.