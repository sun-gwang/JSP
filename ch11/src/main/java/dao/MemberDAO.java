package dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import db.DBHelper;
import dto.MemberDTO;

public class MemberDAO extends DBHelper{
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertMember(MemberDTO member) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("INSERT INTO `member` VALUES (?,?,?,?,?,NOW())");
			psmt.setString(1, member.getUid());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getHp());
			psmt.setString(4, member.getPos());
			psmt.setString(5, member.getDep());
			logger.info("psmt : " + psmt);
			
			psmt.executeUpdate();
			
			closeALL();
			
		} catch (Exception e) {
			logger.error("insertMember() : "+ e.getMessage());
		}
	}
	
	public MemberDTO selectMember(String uid) {
		
		MemberDTO member = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `member` WHERE `uid`=?");
			psmt.setString(1, uid);
			logger.info("psmt : "+psmt);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				
				member.setUid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setHp(rs.getString(3));
				member.setPos(rs.getString(4));
				member.setDep(rs.getString(5));
				member.setRdate(rs.getString(6));
				
			}
			closeALL();
		} catch (Exception e) {
			logger.error("selectMember() : "+e.getMessage());
		}
		
		return member;
		
	}
	public List<MemberDTO> selectMembers() {
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			
			logger.info("psmt : " + psmt);
			
			rs = stmt.executeQuery("SELECT * FROM `member`");
			while(rs.next()) {
				member = new MemberDTO();
				member.setUid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setHp(rs.getString(3));
				member.setPos(rs.getString(4));
				member.setDep(rs.getString(5));
				member.setRdate(rs.getString(6));
				
				members.add(member);
			}
			closeALL();
			
		} catch (Exception e) {
			logger.error("selectMembers() : " + e.getMessage());
		}
		return members;
	}
	public void updateMember(MemberDTO member) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("UPDATE `member` SET `name`=?, `hp`=? WHERE `uid`=? ");
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getHp());
			psmt.setString(3, member.getUid());
			
			logger.info("psmt : " + psmt);
			
			psmt.executeUpdate();
			closeALL();
		} catch (Exception e) {
			logger.error("updateMember() : " + e.getMessage());
		}
	}
	public void deleteMember(String uid) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `member` WHERE `uid`=?");
			psmt.setString(1, uid);
			logger.info("psmt : " + psmt);
			psmt.executeUpdate();
			
			closeALL();
		} catch (Exception e) {
			logger.error("deleteMember() : " + e.getMessage());
		}
	}
	
	
}
