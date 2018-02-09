package com.topmobile.bean;

public class SessionUser {
	public static final String ROLE_ADMIN = "100";
	//用户id
	private String id ;
	//登录人角色
	private String role;
	//登录人账号
	private String account ;
	//登录人昵称
	private String name ;
	
	
	public SessionUser(String id,String role, String account, String name) {
		super();
		this.id = id ;
		this.role = role;
		this.account = account;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
