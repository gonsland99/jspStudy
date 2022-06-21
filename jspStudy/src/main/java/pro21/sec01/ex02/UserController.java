package pro21.sec01.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		String userID = "";
		String passwd = "";
		ModelAndView mv = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		mv.addObject("userID", userID);
		mv.addObject("passwd", passwd);
		mv.setViewName("result");
		
		return mv;
	}
}
