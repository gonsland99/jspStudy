package pro17.sec02.ex01;

import java.util.List;

public class BoardService {
	BoardDAO dao;
	
	public BoardService() {
		dao = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> list = dao.selectAllArticles();
		return list;
	}

}
