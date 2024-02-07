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
	
	public ArticleDTO selectArticle(String no) {
		ArticleDTO article = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			System.out.println(psmt);
			rs = psmt.executeQuery();
			if(rs.next()) {
				article = new ArticleDTO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComent(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setWriter(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				
			}
			
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}
	
	public List<ArticleDTO> selectArticles(int start) {
			
		
		List<ArticleDTO> articles = new ArrayList<>();
		try {
			
			ArticleDTO article = null;
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				article = new ArticleDTO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComent(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setWriter(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				article.setNick(rs.getString(12));
				articles.add(article);
			}
			
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articles;
	}
	
	public void updateArticle(ArticleDTO article) {}
	
	public void deleteArticle(int no) {}
	
	// 사용자 정의 CRUD  메서드
	public int selectCountTotal() {
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total=rs.getInt(1);
			}
			
			closeALL();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public void updateHitCount(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_HIT_COUNT);
			psmt.setString(1, no);
			System.out.println(psmt);
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}