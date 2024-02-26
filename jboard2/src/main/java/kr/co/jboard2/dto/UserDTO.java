package kr.co.jboard2.dto;

public class UserDTO {
	
	private String uid;
	private String pass;
	private String name;
	private String nick;
	private String email;
	private String hp;
	private String role;
	private String zip;
	private String addr1;
	private String addr2;
	private String rgip;
	private String sms;
	private String rdate;
	private String leaveDate;
	
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getRgip() {
		return rgip;
	}
	public void setRgip(String rgip) {
		this.rgip = rgip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	
	
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", pass=" + pass + ", name=" + name + ", nick=" + nick + ", email=" + email
				+ ", hp=" + hp + ", role=" + role + ", zip=" + zip + ", addr1=" + addr1 + ", addr2=" + addr2 + ", rgip="
				+ rgip + ", sms=" + sms + ", rdate=" + rdate + ", leaveDate=" + leaveDate + "]";
	}
	
	
	
}
