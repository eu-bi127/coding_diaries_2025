package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.dto.GuestDto;

public interface GuestMapper {
	public ArrayList<GuestDto> getList(int limitIndex);
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);

}


//mapper는 보통 SQL을 실행하는 역할을 한다. MyBatis에서 Mapper는 SQL과 Java 객체 사이를 연결하는 핵심 인터페이스입니다.

//인터페이스(Interface) 는 Java에서 일종의 설계도입니다.
//인터페이스는 메서드의 "이름과 시그니처"만 정의하고, 구현은 하지 않습니다.
//실제 구현은 XML 또는 Java 클래스에서 이뤄지고, Spring과 MyBatis는 이 인터페이스를 자동으로 구현체에 연결해줍니다.


