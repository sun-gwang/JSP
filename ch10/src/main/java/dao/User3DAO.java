package dao;

import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import dto.User3DTO;

public class User3DAO extends DBHelper{

	private static User3DAO instance = new User3DAO();
	public static User3DAO getInstance() {
		return instance;
	}
	private User3DAO() {}
	
	public void insertUser3 (User3DTO user) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("INSERT INTO `user3`VALUES (?,?,?,?,?)");
			psmt.setString(1, user.getUid());
			psmt.setString(2, user.getName());
			psmt.setString(3, user.getBirth());
			psmt.setString(4, user.getHp());
			psmt.setString(5, user.getAddr());
			
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public User3DTO selectUser3 (String uid) {
		
		User3DTO user3 = null;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `user3` WHERE `uid`=?");
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user3 = new User3DTO();
				user3.setUid(rs.getString(1));
				user3.setName(rs.getString(2));
				user3.setBirth(rs.getString(3));
				user3.setHp(rs.getString(4));
				user3.setAddr(rs.getString(5));
				
			}
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user3;
		
	}
	
	public List<User3DTO> selectUser3s () {
		
		List<User3DTO> users = new ArrayList<>();
		User3DTO user3DTO = null;
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery("SELECT * FROM `user3`");
			
			while(rs.next()) {
				user3DTO = new User3DTO();
				user3DTO.setUid(rs.getString(1));
				user3DTO.setName(rs.getString(2));
				user3DTO.setBirth(rs.getString(3));
				user3DTO.setHp(rs.getString(4));
				user3DTO.setAddr(rs.getString(5));
				
				users.add(user3DTO);
			}
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	public void updateUser3 (User3DTO user) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("UPDATE `user3` SET `name`=?, `birth`=?, `hp`=?, `addr`=? WHERE `uid`=?");
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getBirth());
			psmt.setString(3, user.getHp());
			psmt.setString(4, user.getAddr());
			psmt.setString(5, user.getUid());
			
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser3 (String uid) {
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `user3` WHERE `uid`=?");
			psmt.setString(1, uid);
			psmt.executeUpdate();
			
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
