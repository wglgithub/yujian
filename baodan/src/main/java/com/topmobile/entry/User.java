package com.topmobile.entry;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.topmobile.util.Constants;
/**
 * 
 * @描述 报单用户表
 * @author wgl
 * @date 2018年2月9日
 */
@Entity
@Table(name="user")
public class User extends BaseEntry {

	private static final long serialVersionUID = 837623709991518277L;

	//账号
	@Column(nullable=true,unique=true)
	private String account ;
	//密码
	@Column
	private String pwd ;
	//绑定的手机号码
	@Column(nullable=false)
	private String mobile ;
	//名称
	@Column(nullable=false)
	private String name  ;
	//账号角色 抢手、代理、管理员
	@Column(nullable=false)
	private String role =Constants.Role.QIANG_SHOU ;
	/**
	 * 上级id
	 */
	@Column
	private String parent ;
	//头像,存储相对文件根目录下保存路径
	@Column
	private String face;
	//所在地
	@Column
	private String location ;
	//qq号
	@Column
	private String qq ;
	//身份证号码
	@Column
	private String cardId ;
	//支付宝账号
	@Column
	private String alipay ;
	
	//身份证照片正面
	@Column
	private String cardImgFront ;
	//身份证照片反面
	@Column
	private String cardImgBack ;
	//性别
	@Column
	private String sex ;
	
	public User() {}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getAlipay() {
		return alipay;
	}
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	public String getCardImgFront() {
		return cardImgFront;
	}
	public void setCardImgFront(String cardImgFront) {
		this.cardImgFront = cardImgFront;
	}
	public String getCardImgBack() {
		return cardImgBack;
	}
	public void setCardImgBack(String cardImgBack) {
		this.cardImgBack = cardImgBack;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public Map<String,Object> toSimpleData(){
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("id", getId());
		data.put("name", getName());
		data.put("face", getFace());
		data.put("account", getAccount());
		data.put("mobile", getMobile());
		data.put("role", getRole());
		data.put("sex", getSex());
		return data;
	}
	
}
