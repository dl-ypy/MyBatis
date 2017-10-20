package com.ypy.model;

import java.util.List;

public class UserModel {
	private int userid;
	private String username;
	private String password;
	
	private List<Integer> idList;   //in条件查询时用
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
	public List<Integer> getIdList() {
		return idList;
	}
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
}
