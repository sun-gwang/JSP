package dao;

import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import dto.User5DTO;

public class User5DAO extends DBHelper{
	private static User5DAO instance = new User5DAO();
	public static User5DAO getInstance() {
		return instance;
	}
	private User5DAO() {}
	
	public void insertUser5 (User5DTO user) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement( "INSERT INTO `user5` SET `name`=?, `gender`=?, `age`=?, `addr`=?" );
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getGender());
			psmt.setInt(3, user.getAge());
			psmt.setString(4, user.getAddr());
			
			psmt.executeUpdate();
			
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public User5DTO selectUser5 (String seq) {
		
		User5DTO user = null;
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `user5` WHERE `seq`=?");
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new User5DTO();
				user.setSeq(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setAddr(rs.getString(5));
			}
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User5DTO> selectUser5s () {
		
		List<User5DTO> users = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `user5`");
			while(rs.next()) {
				User5DTO user = new User5DTO();
				user.setSeq(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setAddr(rs.getString(5));
				
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void updateUser5 (User5DTO user) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("UPDATE `user5` SET `name`=?, `gender`=?, `age`=?, `addr`=? WHERE `seq`=?");
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getGender());
			psmt.setInt(3, user.getAge());
			psmt.setString(4, user.getAddr());
			psmt.setInt(5, user.getSeq());
			
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteUser5 (String seq) {
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `user5` WHERE `seq`=?");
			psmt.setString(1, seq);
			
			psmt.executeUpdate();
			
			closeALL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
