package com.peisia.dto;

import lombok.Data;

//@Data를 붙이면, getBno(), setBno(Long bno), getBtext(), setBtext(String btext) 같은 메서드를 작성할 필요가 없음.
@Data                   
public class GuestDto {
	private Long bno;
	private String btext;
}

//private: 외부 클래스에서 직접 접근하지 못하도록 보호.
//Long bno: 방명록 글 번호 같은 ID (숫자, 객체형 Long).
//String btext: 방명록에 작성한 내용(텍스트).

//이 클래스의 용도는
//DB나 웹에서 받은 데이터를 Controller → Service → Repository로 전달하거나 반대로 전달할 때 사용됩니다.
//예를 들어, 사용자가 방명록에 글을 작성하면, 해당 내용을 GuestDto로 묶어서 처리하게 됩니다.
