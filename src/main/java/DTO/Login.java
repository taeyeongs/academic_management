package DTO;

public class Login {
	private String id;
	private String pw;
	private String changePw;
	private String loginType;
	private int loginTypeNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getChangePw() {
		return changePw;
	}
	public void setChangePw(String changePw) {
		this.changePw = changePw;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public int getLoginTypeNo() {
		return loginTypeNo;
	}
	public void setLoginTypeNo(int loginTypeNo) {
		this.loginTypeNo = loginTypeNo;
	}
	
	
}
