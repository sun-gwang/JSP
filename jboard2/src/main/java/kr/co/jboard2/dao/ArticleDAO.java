package kr.co.jboard2.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.co.jboard2.db.DBHelper;
import kr.co.jboard2.db.SQL;
import kr.co.jboard2.dto.ArticleDTO;

public class ArticleDAO extends DBHelper{
	
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertArticle(ArticleDTO articleDTO) {
		
		int pk = 0;
		
		try {
			
			conn = getConnection();
			
			// INSERT가 실행되고 자동 실행되는 PK 값을 리턴하는 옵션
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, articleDTO.getTitle());
			psmt.setString(2, articleDTO.getContent());
			psmt.setInt(3, articleDTO.getFile());
			psmt.setString(4, articleDTO.getWriter());
			psmt.setString(5, articleDTO.getRegip());
			logger.info("insertArticle : " + psmt);
			
			// INSERT 실행
			psmt.executeUpdate();
			
			// 생성된 PK 가져오기
			rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				pk = rs.getInt(1);
			}
			closeALL();
			
		} catch (Exception e) {
			logger.error("insertArticle : " + e.getMessage());
			
		}
		return pk;
	}
	public ArticleDTO selectArticle (int no) {
		
		ArticleDTO articleDTO = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setInt(1, no);
			
			logger.info("selectArticle : " + psmt);

			rs = psmt.executeQuery();
			if(rs.next()) {
				articleDTO = new ArticleDTO();
				articleDTO.setNo(rs.getInt(1));
				articleDTO.setParent(rs.getInt(2));
				articleDTO.setComent(rs.getInt(3));
				articleDTO.setCate(rs.getString(4));
				articleDTO.setTitle(rs.getString(5));
				articleDTO.setContent(rs.getString(6));
				articleDTO.setFile(rs.getInt(7));
				articleDTO.setHit(rs.getInt(8));
				articleDTO.setWriter(rs.getString(9));
				articleDTO.setRegip(rs.getString(10));
				articleDTO.setRdate(rs.getString(11));
			}
			closeALL();
		} catch (Exception e) {
			logger.error("selectArticle() : " + e.getMessage());
		}
		
		return articleDTO;
		}
	
	
	public List<ArticleDTO> selectArticles() {
		
		List<ArticleDTO> articles = new ArrayList<>();
		
		ArticleDTO articleDTO = null;
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_ARTICLES);
			logger.info("selectArticles : " + psmt);
			
			while(rs.next()) {
				articleDTO = new ArticleDTO();
				articleDTO.setNo(rs.getInt(1));
				articleDTO.setParent(rs.getInt(2));
				articleDTO.setComent(rs.getInt(3));
				articleDTO.setCate(rs.getString(4));
				articleDTO.setTitle(rs.getString(5));
				articleDTO.setContent(rs.getString(6));
				articleDTO.setFile(rs.getInt(7));
				articleDTO.setHit(rs.getInt(8));
				articleDTO.setWriter(rs.getString(9));
				articleDTO.setRegip(rs.getString(10));
				articleDTO.setRdate(rs.getString(11));
				articleDTO.setNick(rs.getString(12));
				articles.add(articleDTO);
			}
			
			closeALL();
		} catch (Exception e) {
			logger.error("selectArticles() : " + e.getMessage());
		}
		
		return articles;
	}
	
	public int selectCountTotal() {
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL);
			rs   = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			closeALL();
		} catch (Exception e) {
			logger.error("selectCountTotal() " + e.getMessage());
		}
		return total;
	}
	
	public void updateArticles(ArticleDTO articleDTO) {}
	public void deleteArticles(int no) {}
}
