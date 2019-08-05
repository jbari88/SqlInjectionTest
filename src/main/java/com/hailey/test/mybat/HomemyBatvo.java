package com.hailey.test.mybat;


public class HomemyBatvo {
	
	String id;
	String name;
	String passwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public HomemyBatvo(String id, String name, String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "HomeiBVo [id=" + id + ", name=" + name + ", passwd=" + passwd + "]";
	}
	public HomemyBatvo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
