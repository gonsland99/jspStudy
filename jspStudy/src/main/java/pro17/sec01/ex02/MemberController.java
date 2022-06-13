package pro17.sec01.ex02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member/*")
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
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println(action);
		if(action == null || action.equals("/listMember.do")) {
			List<MemberVO> list = dao.listMembers();
			request.setAttribute("list", list);
			nextPage = "/pro17/member2/listMember.jsp";
		}else if(action.equals("/addMember.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pw, name, email);
			dao.addMember(memberVO);
			nextPage = "/member/listMember.do";
		}else if(action.equals("/memberForm.do")) {
			nextPage = "/pro17/member2/memberForm.jsp";
		}else {
			List<MemberVO> list = dao.listMembers();
			request.setAttribute("list", list);
			nextPage = "/pro17/member2/listMember.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
	
}
