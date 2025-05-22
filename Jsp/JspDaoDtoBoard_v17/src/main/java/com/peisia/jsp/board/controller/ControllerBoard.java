//- 파일명 변경. ControllerBoard, ServiceBoard
//- 리스트 종합 처리를 담당하는 BoardListProcessor 를 추가하고 리스트에 적용함(페이지리스트는 아직)

package com.peisia.jsp.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.c.util.Cw;
import com.peisia.jsp.board.BoardListProcessor;
import com.peisia.jsp.board.dto.Dto;
import com.peisia.jsp.board.service.ServiceBoard;

@WebServlet("/board/*")    ///board/*로 들어오는 URL 요청을 이 컨트롤러가 처리
public class ControllerBoard extends HttpServlet {
	String nextPage;
	ServiceBoard service;    //init()에서 ServiceBoard 객체를 초기화하여 서비스 레이어와 연결.
	@Override
	public void init() throws ServletException {          //서블릿이 처음 로드될 때 한 번 실행.
		service = new ServiceBoard();                     //비즈니스 로직을 담당할 ServiceBoard 객체 생성.
	}
	@Override                                             //클라이언트의 GET 요청을 처리. //URL 패턴을 통해 어떤 동작인지 구분 (/write, /del, /list 등).
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
				service.write(dto);	//🐇서비스🐇:쓰기 기능				
				break;
			case "/edit_insert":
				Cw.wn("수정-insert");
				nextPage="/edit.jsp";
				request.setAttribute("post", service.read(request.getParameter("no")));	//🐇서비스🐇:수정 기능				
				break;
			case "/edit_proc":
				Cw.wn("수정-proc");
				nextPage="/board/list";	//컨트롤러 리스트를 타게 수정함				
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
				Dto d=service.read(request.getParameter("no"));	//🐇서비스🐇:읽기 기능
				request.setAttribute("post", d);
				break;
			case "/list":
				nextPage="/list.jsp";
				//todo
				//각종 처리 다 해서 BoardListProcessor 한 객체로 넘기기.
				BoardListProcessor blp = service.list(request.getParameter("currentPage"));	//🐇서비스🐇:리스트 기능
				request.setAttribute("blp", blp);
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);     //결과적으로 RequestDispatcher를 사용해 JSP 페이지로 이동
			d.forward(request,response);
		}
	}
}


//ControllerBoard는 게시판 관련 모든 기능의 진입점(Controller).
//각각의 URL 액션(/write, /del, /read 등)에 대해 ServiceBoard를 호출해 비즈니스 로직을 처리.
//결과는 JSP로 전달하여 사용자에게 렌더링.
//BoardListProcessor는 리스트 처리 전용 헬퍼 클래스로 사용됨 (추후 페이징 추가 예정).

//*추가 클래스 및 개념*
//1. ServiceBoard :
// 비즈니스 로직을 담당하는 서비스 클래스. //예: write(), del(), edit(), read(), list() 등.

//2. Dto
// 데이터 전송 객체 (Data Transfer Object) //게시글의 제목, 작성자 ID, 본문 등을 담음.

//3. BoardListProcessor
// 리스트 페이지의 게시글 목록, 페이징 처리 등을 종합적으로 다룸.
// list() 호출 시 이 객체로 결과를 만들어서 request에 설정함.


