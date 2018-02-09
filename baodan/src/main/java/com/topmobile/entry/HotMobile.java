package com.topmobile.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 热门抢购机型实体
 *
 * @author wgl
 * @date 2017年7月16日 下午10:21:19
 */
@Entity
@Table(name="w_hotmobile")
public class HotMobile extends BaseEntry {

	private static final long serialVersionUID = 6280528307446318113L;
	/**
	 * 所属商城代码
	 */
	@Column(length=32,nullable=false)
	private String mallCode ;
	/**\
	 * 手机型号,如：小米6
	 */
	@Column(length=64,nullable=false)
	private String model ;
	/**
	 * 内存大小、颜色的描述
	 */
	@Column(nullable=false)
	private String describeTxt ;
	/**
	 * 手机售卖类型 0=抢购
	 */
	@Column(nullable=false)
	private int type ;
	/**
	 * 抢购时间 yyyy-MM-dd hh:mm:ss
	 */
	@Column(length=30 ,nullable=false)
	private String panicBuyDate;
	/**
	 * 抢购日期 yyyy-MM-dd
	 */
	@Column(length=30 ,nullable=false)
	private String panicBuyDay ;
	/**
	 * 是否有货
	 */
	@Column(nullable=false)
	private Boolean hasMore=true ;
	/**
	 * 推荐星数，最大值5，默认值为0表示无星级推荐
	 */
	@Column(nullable=false)
	private int star ;
	/**
	 * 购买链接
	 */
	@Column(columnDefinition="text",nullable=false)
	private String buyLink ;
	
	public HotMobile() {}
	
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
	
	public String getDescribeTxt() {
		return describeTxt;
	}

	public void setDescribeTxt(String describeTxt) {
		this.describeTxt = describeTxt;
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
	
	public String getPanicBuyDay() {
		return panicBuyDay;
	}
	
	public void setPanicBuyDay(String panicBuyDay) {
		this.panicBuyDay = panicBuyDay;
	}
	
}
