package pro17.sec02.ex06;

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

	public int addArticle(ArticleVO vo) {
		return dao.insertNewArticle(vo);
	}

	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article = null;
		article = dao.selectArticle(articleNO);
		return article;
	}

	public void modArticle(ArticleVO vo) {
		dao.updateArticle(vo);
	}
	
	public List<Integer> removeArticle(int  articleNO) {
		List<Integer> articleNOList = dao.selectRemovedArticles(articleNO);
		dao.deleteArticle(articleNO);
		return articleNOList;
	}
}
