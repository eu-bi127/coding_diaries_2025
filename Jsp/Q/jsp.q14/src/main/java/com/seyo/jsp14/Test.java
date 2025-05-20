//서블릿의 doGet()함수에서 id,pw 값을 꺼내서 (request 객체에서 꺼내기) 콘솔에 출력하기
// = **서블릿(Servlet)**을 사용해 GET 방식의 요청을 처리하면서, 클라이언트(브라우저)에서 전송한 파라미터(id, pw) 값을 콘솔에 출력하는 예제.
package com.seyo.jsp14;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")                  //이 서블릿 클래스는 웹에서 /Test URL로 접근. //예: http://localhost:8080/프로젝트명/Test?id=abc&pw=1234
public class Test extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==== 두 겟");
		System.out.println("id: "+ req.getParameter("id"));
		System.out.println("pw: "+ req.getParameter("pw")); 
	}

}
