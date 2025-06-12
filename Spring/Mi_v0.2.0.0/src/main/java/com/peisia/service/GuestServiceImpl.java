//GuestServiceImpl이 실제로 인터페이스에 정의된 메서드를 구현하고 있으며, Mapper를 이용해 SQL을 실행하고 있습니다.
//Service는 컨트롤러와 데이터 계층 사이에서 비즈니스 로직을 중계/처리하는 역할.
//이 클래스는 GuestService 인터페이스를 구현하여, 비즈니스 로직을 처리하고, 데이터 접근 계층(GuestMapper)과 컨트롤러 사이를 이어주는 역할임.

package com.peisia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.dto.GuestDto;
import com.peisia.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j 
@Service           //이 클래스가 서비스 컴포넌트임을 spring에 알리는 애너테이션. //spring이 이 클래스를 자동으로 Bean으로 등록하고 DI(의존성 주입) 대상에 포함시킴.
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)    //이 문법은 Lombok과 spring의 결합 기능. 
	private GuestMapper mapper;	       //mapper 필드에 대해 자동으로 setter 메서드를 생성하고, 해당 메서드에 @Autowired를 붙이는 것과 같다.
	
	@Override
	public ArrayList<GuestDto> getList(int currentPage) {
		log.info("비지니스 계층===========");
		int limitIndex = (currentPage-1) * 5;       //현재 페이지 번호를 받아서, 페이징을 위한 인덱스 계산.
		return mapper.getList(limitIndex);
	}
	
	
	@Override
	public GuestDto read(long bno) {          //특정 방명록 글 번호(bno)에 해당하는 글 데이터를 가져옴
		return mapper.read(bno);
	}
	
	@Override
	public void del(long bno) {              //해당 번호의 글을 삭제
		mapper.del(bno);
	}
	
	@Override
	public void write(GuestDto dto) {         //새 글 등록 //dto에 들어 있는 btext 값이 insert 퀴리로 들어감.
		mapper.write(dto);
	}		
	
	@Override
	public void modify(GuestDto dto) {        //기존 글 수정 //dto에는 수정할 글 번(bno)와 내용(btext)이 담겨 있다.
		mapper.modify(dto);
	}	
}
