package pro17.sec02.ex01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardService service;
    ArticleVO vo;
	
    public void init() throws ServletException{
    	service = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action: "+action);
		try {
			List<ArticleVO> list = new ArrayList<>();
			if(action == null) {
				list = service.listArticles();
				request.setAttribute("list", list);
				nextPage = "/pro17/board/listArticles.jsp";
			}else if(action.equals("/list.do")) {
				list = service.listArticles();
				request.setAttribute("list", list);
				nextPage = "/pro17/board/listArticles.jsp";
			}else {
				list = service.listArticles();
				request.setAttribute("list", list);
				nextPage = "/pro17/board/listArticles.jsp";
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
