package com.seyo.jsp13;

import java.io.IOException;  //예외 처리를 위해 필요합니다. 웹 요청 처리 중 예외가 발생할 수 있기 때문.
import java.io.PrintWriter;  //응답을 브라우저에 출력하기 위한 출력 스트림.

import javax.servlet.ServletException;  //예외 처리를 위해 필요합니다. 웹 요청 처리 중 예외가 발생할 수 있기 때문.
import javax.servlet.annotation.WebServlet; //이 서블릿이 어떤 URL 요청을 처리할지 지정.
//HttpServlet, HttpServletRequest, HttpServletResponse: 서블릿의 핵심 클래스들.
import javax.servlet.http.HttpServlet;    //서블릿을 만들기 위해 상속받는 클래스.
import javax.servlet.http.HttpServletRequest;   //클라이언트(브라우저)로부터의 요청 정보를 담고 있음.
import javax.servlet.http.HttpServletResponse;  //클라이언트로 보낼 응답을 다룸.

//이 서블릿이 어떤 URL로 호출될지를 지정함.
//브라우저에서 http://localhost:포트번호/프로젝트명/ServletHelloWorld로 접근하면 이 서블릿이 실행됨.
@WebServlet("/ServletHelloWorld")    //여기가 주소가 된다. 

//HttpServlet을 상속받아서 서블릿 클래스를 정의함.
//Java에서 서블릿을 만들려면 반드시 HttpServlet을 상속해야함.
public class ServletHelloWorld extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//브라우저에서 특정 URL로 접속했을 때 실행되는 메서드가 바로 doGet()
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//응답을 출력할 수 있는 객체인 PrintWriter를 얻어옴.
        //JSP에서는 자동으로 제공되는 out 객체지만, 서블릿에서는 이렇게 명시적으로 받아와야함.
		PrintWriter out = response.getWriter();    //서블릿에서는 jsp랑 다르게, 이 문장을 써야 내장 객체 쓰기위해 따로 코드를 적어줘야함. 외우기. 
		out.println("Hello World !!! ");   //브라우저로 보내주는 것.
		//PrintWriter를 사용해 브라우저에 문자열 출력함.
		//이 문자열이 실제로 HTML 페이지의 본문에 출력함.
	}
}
