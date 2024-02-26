package kr.co.jboard2.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard2.db.DBHelper;
import kr.co.jboard2.db.SQL;
import kr.co.jboard2.dto.UserDTO;

public class UserDAO extends DBHelper{
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance () {
		return instance;
		
	}
	
	private UserDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser(UserDTO user) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_USER);
			
			psmt.setString(1, user.getUid());
			psmt.setString(2, user.getPass());
			psmt.setString(3, user.getName());
			psmt.setString(4, user.getNick());
			psmt.setString(5, user.getEmail());
			psmt.setString(6, user.getHp());
			psmt.setString(7, user.getRgip());
			psmt.setString(8, user.getSms());
			
			logger.info("psmt : " + psmt);
			
			psmt.executeUpdate();
			closeALL();
			
		} catch (Exception e) {
			logger.debug("insertUser : " + e.getMessage());
		}
	}
	public UserDTO selectUser() {
		return null;
	}
	public List<UserDTO> selectUsers() {
		return null; 
	}
	public void updatetUser(UserDTO userDTO) {
		
	}
	public void deleteUser(String uid) {
		
	}
	
	public int selectCountUser(String type, String value) {
		
		StringBuilder sql = new StringBuilder(SQL.SELECT_COUNT_USER);
		
		if(type.equals("uid")) {
			sql.append(SQL.WHERE_UID);
		}else if(type.equals("nick")) {
			sql.append(SQL.WHERE_NICK);
		}else if(type.equals("hp")) {
			sql.append(SQL.WHERE_HP);
		}else if(type.equals("email")) {
			sql.append(SQL.WHERE_EMAIL);
		}
		
		int result = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, value);
			
			logger.info("psmt : " + psmt);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			closeALL();
		} catch (Exception e) {
			logger.error("selectCountUser : " + e.getMessage());
		}
		
		return result;
	}
		

}
