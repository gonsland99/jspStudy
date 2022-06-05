package pro06.sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pro06/input2")
public class InputServlet2 extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("init !!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String val : values) {
				System.out.println("name: "+name+" ,value: "+val);
			}
		}
	}

	public void destroy() {
		System.out.println("destroy !!");
	}
}
