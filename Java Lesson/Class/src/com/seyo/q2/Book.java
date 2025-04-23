package com.seyo.q2;

public class Book {
	String title;
	String author;
	
	 // 생성자 정의
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    Book(){}    //기본적인 정의를 해줘야 함. 아니면 메인에서 오류뜸.
    
	
	void printlnfo() {
		System.out.println("책 제목:" + title + "저자:" + author );
	}
}


//생성자 만들기
//book 클래스를 만들어 다음 정보를 저장하고, 생성자를 만들기
//제목(title)  //저자 (author)  //출력 메서드 printlnfo()


//*this 키워드의 사용
//this는 현재 객체를 창조하는 키워드. 즉, this를 사용하면 현재 인스턴스의 필드나 메서드에 접근할 수 있다.
//필드와 매개변수의 구분: 
//생성자에게 매개변수 이름과 클래스 필드 이름이 동일할 때, this를 사용하여 필드를 명확하게 구분할 수 있다.
//ex) this.title은 클래스의 필드를 의미, title은 생성자 매개변수를 의미함.
//this를 사용하지 않으면, java는 매개변수 title을 우선적으로 참조하게 됨. 
//따라서 this를 사용하여 필드를 명확히 지정하는 것이 중요함.



