package brd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;

@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	BoardService boardService;
	ArticleVO articleVO;

	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			if (action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board/listArticles.jsp";
			} else if (action.equals("/list.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board/listArticles.jsp";
			} else if(action.equals("/articleForm.do")) {
				nextPage = "/board/articleForm.jsp";
			} else if(action.equals("/addArticle.do")) {
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				articleVO.setParentNO(0);
				articleVO.setId("hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.addArticle(articleVO);
				nextPage = "/brd/list.do";
			} else {
				nextPage = "/board/listArticles.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, String> upload(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		Map<String, String> map = new HashMap<>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i=0; i<items.size(); i++) {
				FileItem file = (FileItem) items.get(i);
				if(file.isFormField()) {
					System.out.println(file.getFieldName()+"="+file.getString(encoding));
				} else {
					System.out.println("파라미터명: "+file.getFieldName());
					System.out.println("파일명: "+file.getName());
					System.out.println("파일크기: "+file.getSize()+"byte");
					if(file.getSize() > 0) {
						int idx = file.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = file.getName().lastIndexOf("/");
						}
						String fileName = file.getName().substring(idx+1);
						map.put(file.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath + "\\"+ fileName);
						file.write(uploadFile);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
