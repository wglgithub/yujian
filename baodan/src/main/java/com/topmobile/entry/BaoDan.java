package com.topmobile.entry;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.common.base.Strings;
import com.topmobile.bean.RequestBaodan;

/**
 * 报单表
 *
 * @author wgl
 * @date 2017年11月24日 下午7:02:13
 */
@Table(name="baodan")
@org.hibernate.annotations.Table(appliesTo="baodan",comment="报单表")
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
	private Integer amount ;
	//下单支付金额 单位分
	@Column(nullable=true)
	private long orderPay ;
	//付款方式 0=群主付款,1=货到付款,2=自己垫付
	@Column(nullable=true)
	private Integer payWay ;
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
	private Boolean officalChannels ; 
	//物流单号
	@Column
	private String logisticsNo;
	//订单物流状态 （未发货、已发货、已签收）
	@Column(columnDefinition="enum('未发货','已发货','已签收') DEFAULT '未发货' COMMENT '订单物流状态' ")
	private String fahuoState ="未发货";
	//确认状态
	@Column(columnDefinition="enum('已确认','未确认') DEFAULT '未确认' COMMENT '确认状态' ")
	private String sureState="未确认" ;
	@Column(columnDefinition="enum('代理回款','群主回款','已签收','已发货','已确认','未确认') DEFAULT '未确认' COMMENT '当前处理状态'")
	private String currentState = "未确认";
	//管理员出手单价 单位分
	@Column
	private Long offprice ;
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
	@Column(columnDefinition="enum('已回款','未回款') DEFAULT '未回款'")
	private String paymentState1="未回款";
	//抢手收到回款的状态  未回款、已回款
	@Column(columnDefinition="enum('已回款','未回款') DEFAULT '未回款'")
	private String paymentState2="未回款";
	@Column
	private Long income1 ;
	//代理收益 单位分
	@Column
	private Long income2 ;
	//抢手收益 单位分
	@Column
	private Long income3 ;
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


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public long getOrderPay() {
		return orderPay;
	}


	public void setOrderPay(long orderPay) {
		this.orderPay = orderPay;
	}


	public Integer getPayWay() {
		return payWay;
	}


	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
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


	public Boolean getOfficalChannels() {
		return officalChannels;
	}


	public void setOfficalChannels(Boolean officalChannels) {
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


	public Long getOffprice() {
		return offprice;
	}


	public void setOffprice(Long offprice) {
		this.offprice = offprice;
	}


	public Long getPayment1() {
		return payment1;
	}


	public void setPayment1(Long payment1) {
		this.payment1 = payment1;
	}


	public Timestamp getPayTime1() {
		return payTime1;
	}


	public void setPayTime1(Timestamp payTime1) {
		this.payTime1 = payTime1;
	}


	public Long getPayment2() {
		return payment2;
	}


	public void setPayment2(Long payment2) {
		this.payment2 = payment2;
	}


	public Timestamp getPayTime2() {
		return payTime2;
	}


	public void setPayTime2(Timestamp payTime2) {
		this.payTime2 = payTime2;
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


	public Long getIncome1() {
		return income1;
	}


	public void setIncome1(Long income1) {
		this.income1 = income1;
	}


	public Long getIncome2() {
		return income2;
	}


	public void setIncome2(Long income2) {
		this.income2 = income2;
	}


	public Long getIncome3() {
		return income3;
	}


	public void setIncome3(Long income3) {
		this.income3 = income3;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getCurrentState() {
		return currentState;
	}
	


	public static BaoDan fromRequestBaodan(String userId,RequestBaodan bean) {
		BaoDan d = new BaoDan();
		if(!Strings.isNullOrEmpty(bean.getId())){
			d.setId(bean.getId());
		}
		d.setSubmitUser(userId);
		d.setMall(bean.getMall());
		d.setMobileModel(bean.getModel());
		d.setOfficalChannels(bean.getWay()==0 ? true:false );
		d.setAmount(bean.getAmount());
		d.setOrderPay((long) (bean.getPay()*100));
		d.setPayWay(bean.getPayway());
		d.setOrderNo(bean.getOrderId());
		d.setAddressee(bean.getOrderUser());
		d.setAddress(bean.getOrderAdress());
		d.setPickPhone(bean.getOrderPhone());
		d.setBuyAccount(bean.getOrderAccount());
		d.setBuyAccountPwd(bean.getOrderPwd());
		d.setRemark(bean.getRemark());
		return d;
	}
	
	
}
