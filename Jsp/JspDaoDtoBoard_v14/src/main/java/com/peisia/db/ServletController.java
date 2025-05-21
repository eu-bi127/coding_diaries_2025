//게시판(BOARD) 기능을 제공하는 **서블릿 컨트롤러(ServletController)**
//이전 코드보다 한 단계 발전되어 서비스 계층(Service)을 도입한 구조

package com.peisia.db;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.c.util.Cw;

@WebServlet("/board/*")     ///board/로 시작하는 모든 요청을 이 컨트롤러가 처리
public class ServletController extends HttpServlet {   
	String nextPage;          //nextPage: 다음에 포워딩할 JSP 경로
	Dao dao;                  //Dao, Service: 데이터 접근 및 로직 처리를 위한 객체.
	Service service;          
	
	@Override
	public void init() throws ServletException {      //init() - 객체 초기화 //서블릿이 최초 요청 시 한 번만 실행
		dao = new Dao();                              //DAO와 서비스 계층 객체를 초기화함
		service = new Service();
	}
	
	//doGet() – 요청 분기 처리
	//클라이언트의 GET 요청을 처리
    //request.getPathInfo()로 URL 경로 구분
	//switch 문으로 기능을 분기 처리
	@Override                                          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		Cw.wn("action:"+action);
		if(action!=null) {
			switch(action) {
			case "/del":
				nextPage="/board/list";	//컨트롤러 리스트를 타게 수정함
				service.del(request.getParameter("no"));	//🐇서비스🐇:삭제 기능
				break;
			case "/write":
				nextPage="/board/list";	//컨트롤러 리스트를 타게 수정함
				Dto dto = new Dto(
						request.getParameter("title"),
						request.getParameter("id"),
						request.getParameter("text")
						);
//				dao.write(dto);				
				service.write(dto);	//🐇서비스🐇:쓰기 기능				
				break;
			case "/edit_insert"://todo
				Cw.wn("수정-insert");
				nextPage="/edit.jsp";
//				request.setAttribute("post", dao.read(request.getParameter("no")));	//🐇서비스🐇:수정 기능					
				request.setAttribute("post", service.read(request.getParameter("no")));	//🐇서비스🐇:수정 기능				
				break;
			case "/edit_proc"://todo
				Cw.wn("수정-proc");
				nextPage="/board/list";	//컨트롤러 리스트를 타게 수정함
//				dao.edit(
//						new Dto(
//								request.getParameter("title"),
//								request.getParameter("text")
//								)
//						,request.getParameter("no")
//						);	//🐇서비스🐇:수정 기능				
				service.edit(
						new Dto(
								request.getParameter("title"),
								request.getParameter("text")
								)
						,request.getParameter("no")
						);	//🐇서비스🐇:수정 기능				
				break;
			case "/read":
				nextPage="/read.jsp";
//				Dto d=dao.read(request.getParameter("no"));
				Dto d=service.read(request.getParameter("no"));	//🐇서비스🐇:읽기 기능
				request.setAttribute("post", d);
				break;
			case "/list":
				nextPage="/list.jsp";
//				ArrayList<Dto> posts = dao.list();	//🐇서비스🐇:리스트 기능
				ArrayList<Dto> posts = service.list();	//🐇서비스🐇:리스트 기능
				request.setAttribute("posts", posts);
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request,response);
		}
	}
}