package com.peisia.service;

import java.util.ArrayList;

import com.peisia.dto.GuestDto;


public interface GuestService {                  
	public ArrayList<GuestDto> getList(int currentPage);       //방명혹 리스트를 페이지 단위로 가져옴
	public GuestDto read(long bno);                            //bno는 방명록 글 번호, 하나의 게시글 데이터를 GuestDto 형태로 반환
	public void del(long bno);                                 //게시글 삭제, bno에 해당하는 행을 DB에서 삭제
	public void write(GuestDto dto);                           //새 게시글 등록, DTO 안에 게시글 내용이 담겨 있음
	public void modify(GuestDto dto);                          //기존 게시글 수정, dto.bno로 어떤 글을 수정할지 판단, dto.btext로 수정된 내용 전달
}


//service 계층
//역할: 비즈니스 로직(Business Logic)을 담당
//단순히 DB에서 가져오기만 하는 게 아니라, 가공, 검증, 페이징 계산, 트랜잭션 처리 등의 중간 처리 로직이 들어갑니다.

//인터페이스 선언
//구체적인 구현 내용은 없고, 기능만 정의되어 있음.