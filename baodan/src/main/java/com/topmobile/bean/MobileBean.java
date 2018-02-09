package com.topmobile.bean;


public class MobileBean {
	/**
	 * 所属商城代码
	 */
	private String mallCode ;
	/**\
	 * 手机型号,如：小米6
	 */
	private String model ;
	/**
	 * 内存大小、颜色的描述
	 */
	private String describe ;
	/**
	 * 手机售卖类型 0=抢购
	 */
	private int type ;
	/**
	 * 抢购时间
	 */
	private String panicBuyDate;
	/**
	 * 是否有货
	 */
	private Boolean hasMore=true ;
	/**
	 * 推荐星数，最大值5，默认值为0表示无星级推荐
	 */
	private int star ;
	
	private String buyLink ;
	
	public String getMallCode() {
		return mallCode;
	}
	public void setMallCode(String mallCode) {
		this.mallCode = mallCode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPanicBuyDate() {
		return panicBuyDate;
	}
	public void setPanicBuyDate(String panicBuyDate) {
		this.panicBuyDate = panicBuyDate;
	}
	public Boolean getHasMore() {
		return hasMore;
	}
	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getBuyLink() {
		return buyLink;
	}
	
	public void setBuyLink(String buyLink) {
		this.buyLink = buyLink;
	}
	
}
