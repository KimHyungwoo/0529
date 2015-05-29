package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardListAction;
import board.action.BoardWriteAction;
import board.action.BoardWriteFormAction;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board") // 앞에는 어떠한 것이 와도 상관없지만 뒤에는 .board(확장자 노출이 안됨)
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("GG");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// System.out.println("GG");
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(contextPath.length()); // substring : 글씨를 잘라온다는 의미
		
/*		System.out.println(contextPath);
		System.out.println(uri);
		System.out.println("command : " + command);*/
		
		// 글쓰기 폼
		if(command.equals("/writeForm.board")) {
			Action action = new BoardWriteFormAction(); // new 할때는 자식, 담을때는 부모
			action.execute(request, response); // 동적바인딩, 해당 execute 실행해야 됨
		}
		
		// 글쓰기
		else if(command.equals("/write.board")) {
			// System.out.println("/write.board"); // 확인해보는 것 
			Action action = new BoardWriteAction(); 
			action.execute(request, response); 
			
		}
		
		// 리스트
		else if(command.equals("/list.board")) {
			Action action = new BoardListAction(); 
			action.execute(request, response); 
		}
	}

}
