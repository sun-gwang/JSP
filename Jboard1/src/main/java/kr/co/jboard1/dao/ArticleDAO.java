package kr.co.jboard1.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard1.db.DBHelper;
import kr.co.jboard1.db.SQL;
import kr.co.jboard1.dto.ArticleDTO;

public class ArticleDAO extends DBHelper{
	
	// 싱글톤
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	
	public void insertArticle(ArticleDTO article) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setString(3, article.getWriter());
			psmt.setString(4, article.getRegip());
			
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArticleDTO selectArticle(int no) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setInt(1, no);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ArticleDTO> selectArticles() {
			
		
		List<ArticleDTO> articles = new ArrayList<>();
		try {
			
			ArticleDTO dto = null;
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(SQL.SELECT_ARTICLES);
			
			while(rs.next()) {
				dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setComent(rs.getInt(3));
				dto.setCate(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setFile(rs.getInt(7));
				dto.setHit(rs.getInt(8));
				dto.setWriter(rs.getString(9));
				dto.setRegip(rs.getString(10));
				dto.setRdate(rs.getString(11));
				articles.add(dto);
			}
			
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articles;
	}
	
	public void updateArticle(ArticleDTO article) {}
	
	public void deleteArticle(int no) {}
	
}
