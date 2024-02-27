package kr.co.jboard2.service;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.co.jboard2.dao.UserDAO;
import kr.co.jboard2.dto.UserDTO;

public class UserService {
	
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	private UserService() {}
	
	private Logger loger = LoggerFactory.getLogger(this.getClass());
	private UserDAO dao = UserDAO.getInstance();
	
	public void insertUser(UserDTO user) {
		dao.insertUser(user);
	}
	
	public UserDTO selectUser() {
		return dao.selectUser();
	}
	public List<UserDTO> selectUsers() {
		return dao.selectUsers(); 
	}
	
	public UserDTO selectUserForLogin(String uid, String pass) {
		return dao.selectUserForLogin(uid, pass);
	}
	public void updatetUser(UserDTO userDTO) {
		dao.updatetUser(userDTO);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
	public int selectCountUser(String Type, String Value) {
		return dao.selectCountUser(Type, Value);
	}
	public void sendEmailCode(HttpSession session, String receiver) {
		
		// 인증코드 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
		session.setAttribute("code", code); 
		
		// 이메일 기본정보
		String sender = "kkj80911@gmail.com";
		String password = "qmnl fcqz qywd hivi"; // 앱 비밀번호
		String title   = "jboard 인증코드 입니다.";
		String content = "<h1>인증코드는 " + code + "입니다.</h1>";
		
		
		// Gmail SMTP 서버 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		
		try{
			// Gmail STMP 세션 생성
			Session gmailSession = Session.getInstance(props, new Authenticator(){
				@Override
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(sender, password);
				}
			});
			
			// 메일 객체 생성 및 설정
			Message message = new MimeMessage(gmailSession);
			message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=UTF-8");
			
			// 메일 발송
			Transport.send(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public int confirmEmailCode(HttpSession session, String code) {
		
		String sessCode = String.valueOf(session.getAttribute("code")) ;
		
		if(sessCode.equals(code)) {
			// 성공
			return 1;
		}else {
			// 실패
			return 0;
		}		
	}
}
