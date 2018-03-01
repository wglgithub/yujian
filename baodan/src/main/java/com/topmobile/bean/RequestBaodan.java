package com.topmobile.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RequestBaodan {
	private String id ;
	//商城id
	@NotNull(message="请选择商城")
	private String mall;
	@NotNull(message="请选择渠道")
	private Integer way =0; //渠道方式 0官方 1第三方
	@NotNull(message="请选择机型")
	private String model ; //机型id
	@NotNull(message="请选择支付方式")
	private Integer payway ; //支付方式 0=群主付款 1=货到付款 2=自己垫付
	@NotNull(message="请填写上报数量")
	@Min(value=1,message="上报数量必须大于等于1")
	private Integer amount ; //上报数量
	@NotNull(message="请填写实付金额")
	@Min(value=0,message="实付金额大于等于零")
	private Double pay ;
	@NotNull(message="请填写订单号")
	private String orderId ; //订单号
	@NotNull(message="请填写收货人姓名")
	private String orderUser ;//收获人
	@NotNull(message="请填写收货人电话")
	private String orderPhone ; //收货人电话
	@NotNull(message="请填写收获地址")
	private String orderAdress ; //收获地址
	private String orderAccount ; //下单账号
	private String orderPwd ; //下单账号的密码
	private String remark ; //备注
	public String getMall() {
		return mall;
	}
	public void setMall(String mall) {
		this.mall = mall;
	}
	public Integer getWay() {
		return way;
	}
	public void setWay(Integer way) {
		this.way = way;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPayway() {
		return payway;
	}
	public void setPayway(Integer payway) {
		this.payway = payway;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getPay() {
		return pay;
	}
	public void setPay(Double pay) {
		this.pay = pay;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public String getOrderAdress() {
		return orderAdress;
	}
	public void setOrderAdress(String orderAdress) {
		this.orderAdress = orderAdress;
	}
	public String getOrderAccount() {
		return orderAccount;
	}
	public void setOrderAccount(String orderAccount) {
		this.orderAccount = orderAccount;
	}
	public String getOrderPwd() {
		return orderPwd;
	}
	public void setOrderPwd(String orderPwd) {
		this.orderPwd = orderPwd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
}
