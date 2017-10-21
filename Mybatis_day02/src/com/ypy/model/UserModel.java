package com.ypy.model;

public class UserModel {
	private int userid;
	private String username;
	private String password;
	private int did;
	
	private DepartMentModel dept;
	
	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DepartMentModel getDept() {
		return dept;
	}
	public void setDept(DepartMentModel dept) {
		this.dept = dept;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
}
