package kr.co.jboard2.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.co.jboard2.db.DBHelper;
import kr.co.jboard2.db.SQL;
import kr.co.jboard2.dto.ArticleDTO;
import kr.co.jboard2.dto.FileDTO;

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
	
	public int insertComment(ArticleDTO articleDTO) {
		
		int pk = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT , Statement.RETURN_GENERATED_KEYS);
			psmt.setInt(1,articleDTO.getParent());
			psmt.setString(2,articleDTO.getContent());
			psmt.setString(3,articleDTO.getWriter());
			psmt.setString(4,articleDTO.getRegip());
			logger.info("insertComment()" + psmt);
			
			// INSERT 해서 부여된 AUTO_INCREMENT PK 값 가져오기
			rs = psmt.getGeneratedKeys();
			
			if(rs.next()) {
				pk = rs.getInt(1);
			}
			closeALL();
		} catch (Exception e) {
			logger.error("insertComment " + e.getMessage());
		}
		
		return pk;
	}
	public ArticleDTO selectArticle (int no) {
		
		List<FileDTO> files = new ArrayList<>();
		ArticleDTO articleDTO = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setInt(1, no);
			
			logger.info("selectArticle : " + psmt);

			rs = psmt.executeQuery();
			while(rs.next()) {
				
				// 글 하나당 파일이 여러개일 경우 글객체(articleDTO)는 여러게 생성할 필요가 없기 때문에
				// 1개만 생성되도록 조건 처리
				if(articleDTO == null) {
					
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
				
				FileDTO fileDTO = new FileDTO();
				fileDTO.setFno(rs.getInt(12));
				fileDTO.setAno(rs.getInt(13));
				fileDTO.setoName(rs.getString(14));
				fileDTO.setsName(rs.getString(15));
				fileDTO.setDownload(rs.getInt(16));
				fileDTO.setRdate(rs.getString(17));
				files.add(fileDTO);
			}
			
			articleDTO.setFileDTOs(files);
			
			closeALL();
		} catch (Exception e) {
			logger.error("selectArticle() : " + e.getMessage());
		}
		
		return articleDTO;
		}
	
	
	public List<ArticleDTO> selectArticles(int start) {
		
		List<ArticleDTO> articles = new ArrayList<>();
		
		ArticleDTO articleDTO = null;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES + SQL.SELECT_ARTICLES_ORDER_LIMIT);
			psmt.setInt(1, start);
			
			logger.info("selectArticles : " + psmt);
			
			rs = psmt.executeQuery();
			
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
	
	
	public List<ArticleDTO> selectComments(int parent) {
		
		List<ArticleDTO> comments = new ArrayList<>();
		
		ArticleDTO articleDTO = null;
		try {
			conn = getConnection();
			psmt= conn.prepareStatement(SQL.SELECT_COMMENTS);
			psmt.setInt(1, parent);
			logger.info("selectComments : " + psmt);
			
			rs = psmt.executeQuery();
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
				comments.add(articleDTO);
			}
			
			closeALL();
		} catch (Exception e) {
			logger.error("selectComments" + e.getMessage());
		}
		return comments;
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
	
	public void updateArticle(ArticleDTO articleDTO) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE);
			psmt.setString(1, articleDTO.getTitle());
			psmt.setString(2, articleDTO.getContent());
			psmt.setInt(3, articleDTO.getNo());
			logger.info("ArticleDTO() : " + psmt);
			
			psmt.executeUpdate();
			
			closeALL();
		} catch (Exception e) {
			logger.error("updateArticle " + e.getMessage());
		}
	}
	
	public void updateArticleForFileCount(int no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE_FOR_FILE_COUNT);
			psmt.setInt(1, no);
			logger.info("updateArticleForFileCount : " + psmt);
			
			psmt.executeUpdate();
			closeALL();
			
		} catch (Exception e) {
			logger.error("updateArticleForFileCount : " + e.getMessage());
		}
	}
	
	public void updateHitCount(int no) {
		try {
				conn = getConnection();
				psmt = conn.prepareStatement(SQL.UPDATE_HIT_COUNT);
				psmt.setInt(1, no);
				logger.info("updateHitCount" + psmt);
				psmt.executeUpdate();
				
				closeALL();
			
		} catch (Exception e) {
			logger.error("updateHitCount()" + e.getMessage());
		}
	}
	
	public void deleteArticle(int no) {
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_ARTICLE);
			psmt.setInt(1, no);
			psmt.setInt(2, no);
			logger.info("deleteArticle() : " + psmt);
			
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			logger.error("deleteArticle" + e.getMessage());
		}
	}
	
	public int deleteComment(String no) {
		int result = 0;
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, no);
			logger.info("deleteComment() : " + psmt);
			
			result = psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			logger.error("deleteComment : " + e.getMessage());
		}
		return result;
	}
}
