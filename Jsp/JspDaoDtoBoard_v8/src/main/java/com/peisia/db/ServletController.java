//컨트롤러 추가.
//컨트롤러를 통해 삭제 기능을 처리하도록. 

package com.peisia.db;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.c.util.Cw;

@WebServlet("/board/*")
public class ServletController extends HttpServlet {      //ServletController: 게시판의 컨트롤러 역할 
	String nextPage;                                      //nextPage: 클라이언트가 최종적으로 이동할 JSP 경로 저장
	Dao dao;                                              //Dao dao: 데이터베이스 접근을 위한 DAO 객체
	
	@Override
	public void init() throws ServletException {          //init()메서드 --- 서블릿이 최초 실행될 때 한 번만 실행
		dao = new Dao();                                  //DB 연결 등을 위한 DAO 객체를 초기화
	}
	
	//doGet() 메서드 정의  -- 클라이언트의 GET 요청을 처리하기 위한 메서드이다.
	//HttpServletRequest request: 사용자의 요청 정보 (URL, 파라미터 등)를 담고 있음.
	//HttpServletResponse response: 응답 정보를 사용자에게 돌려주는 객체.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();    //컨트롤러가 어떤 기능을 수행해야 하는지를 판별하는 데 사용. /board/ 뒤의 URL 경로를 추출 (예: /del, /write)
		Cw.wn("action:"+action);                  //해당 경로를 콘솔에 출력 (디버깅용)
		if(action!=null) {
			switch(action) {
			//했음
			case "/del":        // 콘솔에 로그 출력
				Cw.wn("삭제");    // 삭제 후 목록 페이지로 이동
				nextPage="/list.jsp";      //삭제 후에는 list.jsp로 이동
				dao.del(request.getParameter("no"));   //게시글 번호를 가져와서 DAO의 del() 메서드 호출 (게시글 번호(no)로 삭제 수정)
				break;
			case "/write"://todo
				Cw.wn("쓰기");
				nextPage="/write.jsp";
				break;
			case "/edit"://todo
				Cw.wn("수정");
				nextPage="/edit.jsp";
				break;
			case "/read"://todo
				Cw.wn("읽기");
				nextPage="/read.jsp";
				break;
			case "/list"://todo
				Cw.wn("리스트");
				nextPage="/list.jsp";
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request,response);  //객체만 만들고, 화면에는 나오지 않음.
		}
	}
}