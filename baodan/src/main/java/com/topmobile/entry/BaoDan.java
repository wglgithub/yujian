package com.topmobile.entry;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 报单表
 *
 * @author wgl
 * @date 2017年11月24日 下午7:02:13
 */
@Table(name="baodan")
@Entity
public class BaoDan extends BaseEntry {

	private static final long serialVersionUID = 14517466211875338L;
	//上报人id
	@Column(nullable=true)
	private String submitUser ;
	//抢手所属代理id
	@Column(nullable=true)
	private String proxyId ;
	//商城
	@Column(nullable=true)
	private String mall;
	//手机型号
	@Column(nullable=true)
	private String mobileModel ; 
	//数量
	@Column(nullable=true)
	private int amount ;
	//下单支付金额
	@Column(nullable=true)
	private double orderPay ;
	//订单号
	@Column(nullable=true)
	private String orderNo ;
	//抢购账号
	@Column
	private String buyAccount ;
	//抢购账号的密码
	@Column
	private String buyAccountPwd ;
	//收件人
	@Column(nullable=true)
	private String addressee;
	//收件人电话
	@Column(nullable=true)
	private String pickPhone;
	//收件人地址
	@Column(nullable=true)
	private String address;
	//是否官方渠道货
	@Column(nullable=true)
	private boolean officalChannels ; 
	//物流单号
	@Column
	private String logisticsNo;
	//订单物流状态 （未发货、已发货、已签收）
	@Column
	private String fahuoState ="未发货";
	//确认状态
	@Column
	private String sureState="未确认" ;
	//管理员出手单价 单位分
	@Column
	private long offprice ;
	//代理收到的回款金额 单位分
	@Column
	private Long payment1 ;
	//代理回款时间
	@Column
	private Timestamp payTime1 ;
	//抢手收到的回款金额 单位分
	@Column
	private Long payment2 ;
	//抢手收到回款时间
	@Column
	private Timestamp payTime2 ;
	//代理收到汇款的状态  未回款、已回款
	@Column
	private String paymentState1;
	//抢手收到回款的状态  未回款、已回款
	@Column
	private String paymentState2;
	//管理员收益 单位分
	@Column
	private long income1 ;
	//代理收益 单位分
	@Column
	private long income2 ;
	//抢手收益 单位分
	@Column
	private long income3 ;
	//备注
	@Column
	private String remark ;
	public BaoDan() {}
	
	public String getSubmitUser() {
		return submitUser;
	}
	public void setSubmitUser(String submitUser) {
		this.submitUser = submitUser;
	}
	public String getProxyId() {
		return proxyId;
	}
	public void setProxyId(String proxyId) {
		this.proxyId = proxyId;
	}
	public String getMall() {
		return mall;
	}
	public void setMall(String mall) {
		this.mall = mall;
	}
	public String getMobileModel() {
		return mobileModel;
	}
	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getOrderPay() {
		return orderPay;
	}
	public void setOrderPay(double orderPay) {
		this.orderPay = orderPay;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getBuyAccount() {
		return buyAccount;
	}
	public void setBuyAccount(String buyAccount) {
		this.buyAccount = buyAccount;
	}
	public String getBuyAccountPwd() {
		return buyAccountPwd;
	}
	public void setBuyAccountPwd(String buyAccountPwd) {
		this.buyAccountPwd = buyAccountPwd;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getPickPhone() {
		return pickPhone;
	}
	public void setPickPhone(String pickPhone) {
		this.pickPhone = pickPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isOfficalChannels() {
		return officalChannels;
	}
	public void setOfficalChannels(boolean officalChannels) {
		this.officalChannels = officalChannels;
	}
	public String getLogisticsNo() {
		return logisticsNo;
	}
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	public String getFahuoState() {
		return fahuoState;
	}
	public void setFahuoState(String fahuoState) {
		this.fahuoState = fahuoState;
	}
	public String getSureState() {
		return sureState;
	}
	public void setSureState(String sureState) {
		this.sureState = sureState;
	}
	public double getOffprice() {
		return offprice;
	}
	
	public long getPayment1() {
		return payment1;
	}

	public void setPayment1(long payment1) {
		this.payment1 = payment1;
	}

	public long getPayment2() {
		return payment2;
	}

	public void setPayment2(long payment2) {
		this.payment2 = payment2;
	}

	public void setOffprice(long offprice) {
		this.offprice = offprice;
	}

	public void setIncome1(long income1) {
		this.income1 = income1;
	}

	public void setIncome2(long income2) {
		this.income2 = income2;
	}

	public void setIncome3(long income3) {
		this.income3 = income3;
	}

	public String getPaymentState1() {
		return paymentState1;
	}
	public void setPaymentState1(String paymentState1) {
		this.paymentState1 = paymentState1;
	}
	public String getPaymentState2() {
		return paymentState2;
	}
	public void setPaymentState2(String paymentState2) {
		this.paymentState2 = paymentState2;
	}
	public double getIncome1() {
		return income1;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}