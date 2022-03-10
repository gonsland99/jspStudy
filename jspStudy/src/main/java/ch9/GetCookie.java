package ch9;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/get")
public class GetCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] values = request.getCookies();
		for(int i=0; i<values.length; i++) {
			if(values[i].getName().equals("cookieTest")) {
				out.println("<h2>Cookie값 : "+URLDecoder.decode(values[i].getValue(),"utf-8"));
			}
		}
	}
}
