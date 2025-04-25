package com.peisia.c.board;

public class Post {
	String title;
	String content;
	String writer;
	public Post(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	void info() {
		String s  = String.format("제목: %s",title);
		System.out.println(s);
	}
}