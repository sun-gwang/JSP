package kr.co.jboard1.dto;

public class UserDTO {
	private String uid;
	private String pass;
	private String name;
	private String nick;
	private String email;
	private String hp;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", pass=" + pass + ", name=" + name + ", nick=" + nick + ", email=" + email
				+ ", hp=" + hp + "]";
	}

	
	
}
