package pro05.sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
       
    public ThirdServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {	
		System.out.println("init 호출3");
	}
	public void destroy() {
		System.out.println("destroy 호출3");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("doGet 호출3");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doGet(request, response);
	}

}
