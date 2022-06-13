package pro17.sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/mem.do")
public class MemberController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	MemberDAO dao;
	
	public void init() throws ServletException{
		dao = new MemberDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<MemberVO> list = dao.listMembers();
		request.setAttribute("list", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("/pro17/member/listMember.jsp");
		dispatch.forward(request, response);
	}
	
}
