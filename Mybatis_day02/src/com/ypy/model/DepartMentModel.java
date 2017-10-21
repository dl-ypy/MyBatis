package com.ypy.model;

import java.util.ArrayList;
import java.util.List;

public class DepartMentModel {
	private int did;
	private String dname;
	private List<UserModel> list = new ArrayList<UserModel>();
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<UserModel> getList() {
		return list;
	}
	public void setList(List<UserModel> list) {
		this.list = list;
	}
}
