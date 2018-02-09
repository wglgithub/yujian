package com.topmobile.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 报单使用的商城表
 *
 * @author wgl
 * @date 2017年12月3日 上午1:51:19
 */
@Table(name="bd_mall")
@Entity
public class BaoDanMall extends BaseEntry{

	private static final long serialVersionUID = -6244353653997062066L;

	@Column(unique=true,nullable=false)
	private String name ;
	@Column
	private String remark ;
	
	public BaoDanMall() {}
	public BaoDanMall(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
