package pro14.sec01.ex01;

public class MemberBean {
	String id;
	String pw;
	String name;
	String email;
	
	public MemberBean() {};
	public MemberBean(String id, String pwd, String name, String email) {
		this.id = id;
		this.pw = pwd;
		this.name = name;
		this.email = email;
	}
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
