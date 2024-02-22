package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import dto.User2DTO;

public class User2DAO extends DBHelper{
	
	// 싱글톤 생성
	private static User2DAO instance = new User2DAO();
	
	public static User2DAO getInstance () {
		return instance;
	}
	
	private User2DAO() {}
	
	// CRUD
	public void insertUser2(User2DTO user) {
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("INSERT INTO `user2` VALUES (?,?,?,?)");
			psmt.setString(1, user.getUid());
			psmt.setString(2, user.getName());
			psmt.setString(3, user.getBirth());
			psmt.setString(4, user.getAddr());
			
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public User2DTO selectUser2(String uid) {
		
		User2DTO user = null;
			
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `user2` WHERE `uid`=?");
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new User2DTO();
				
				user.setUid(rs.getString(1));
				user.setName(rs.getString(2));
				user.setBirth(rs.getString(3));
				user.setAddr(rs.getString(4));
				
			}
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
		}
	
	public List<User2DTO> selectUser2s() {
		
		List<User2DTO> users = new ArrayList<>();
		User2DTO user = null;
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs   = stmt.executeQuery("SELECT * FROM `user2`");
			while(rs.next()) {
				user = new User2DTO();
				user.setUid(rs.getString(1));
				user.setName(rs.getString(2));
				user.setBirth(rs.getString(3));
				user.setAddr(rs.getString(4));
				
				users.add(user);
			}
			
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
		}
	public void updateUser2(User2DTO user) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("UPDATE `user2` SET `name`=?, `birth`=?, `addr`=? WHERE `uid`=?");
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getBirth());
			psmt.setString(3, user.getAddr());
			psmt.setString(4, user.getUid());
			
			psmt.executeUpdate();
			
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser2(String uid) {
		
		try{
			
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `user2` WHERE `uid`=?");
			psmt.setString(1, uid);
			psmt.executeUpdate();
			closeALL();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
