package board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// System.out.println("BoardListAction");
		
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.selectAllBoards();
		
		request.setAttribute("list", list);
		
		String url = "./board/list.jsp";
		
		// url을 변경 안 할거니까 포워드방식 사용
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
