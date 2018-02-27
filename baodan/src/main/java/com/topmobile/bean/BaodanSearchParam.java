package com.topmobile.bean;
/**
 * 
 * @描述 资格索引查询参数
 * @author wgl
 * @date 2018年2月27日
 */
public class BaodanSearchParam {
	
	private Integer page ;
	
	private Integer rows ;
	
	private String begin ; //开始日期
	
	private String end ; //结束日期
	
	private String theday ;
	private String user ;
	private String 	mall ;
	private String 	dealway;
	private String 	payway ;
	private String 	model ;
	private String 	recieve ;
	private String	orderno ;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTheday() {
		return theday;
	}
	public void setTheday(String theday) {
		this.theday = theday;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMall() {
		return mall;
	}
	public void setMall(String mall) {
		this.mall = mall;
	}
	public String getDealway() {
		return dealway;
	}
	public void setDealway(String dealway) {
		this.dealway = dealway;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRecieve() {
		return recieve;
	}
	public void setRecieve(String recieve) {
		this.recieve = recieve;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	
	
}
