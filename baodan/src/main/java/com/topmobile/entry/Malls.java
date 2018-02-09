package com.topmobile.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 手机售卖商城表
 *
 * @author wgl
 * @date 2017年7月16日 下午10:50:46
 */
@Entity
@Table(name="w_malls")
public class Malls extends BaseEntry {

	private static final long serialVersionUID = 514135508714173342L;
	/**
	 * 商城名称
	 */
	@Column(nullable=false,unique=true)
	private String name ;
	/**
	 * 商城代码
	 */
	@Column(nullable=false,unique=true)
	private String code ;
	/**
	 * 商城主页地址
	 */
	@Column(nullable=false,columnDefinition="text")
	private String link ;
	public Malls() {}
	public Malls(String name, String code, String link) {
		super();
		this.name = name;
		this.code = code;
		this.link = link;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
