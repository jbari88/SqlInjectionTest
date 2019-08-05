package com.hailey.test.hibvo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class HomeHibVo {
	
	@Id
	@Column(name="id")
	String id;
	
	@Column(name="name")
	String name;
	
	@Column(name="passwd")
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
	public HomeHibVo(String id, String name, String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
	}
	
	
	public HomeHibVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HomeHibVo [id=" + id + ", name=" + name + ", passwd=" + passwd + "]";
	}
	
	
	
	

}
