package pro12.sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "이순신");
		out.println("<html><body>");
		out.println("<h1>세션에 이름 바인딩</h1>");
		out.println("<a href='pro12/session1.jsp'>첫번째 페이지로 이동</a>");
		out.println("</body></html>");
	}

}
