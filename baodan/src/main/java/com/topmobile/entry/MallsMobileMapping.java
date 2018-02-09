package com.topmobile.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 手机型号和商城关系
 *
 * @author wgl
 * @date 2017年8月6日 下午11:27:48
 */
@Entity
@Table(name="w_mmmaping")
public class MallsMobileMapping extends BaseEntry {

	@Column
	private String mallCode ;
	@Column
	private String mallName ;
	@Column
	private String model ;
	
	public MallsMobileMapping() {}
	
	public MallsMobileMapping(String mallCode, String model) {
		super();
		this.mallCode = mallCode;
		this.model = model;
	}
	public MallsMobileMapping(String mallCode,String mallName, String model) {
		super();
		this.mallCode = mallCode;
		this.mallName = mallName ;
		this.model = model;
	}

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
	
	public String getMallName() {
		return mallName;
	}
	
	public void setMallName(String mallName) {
		this.mallName = mallName;
	}
	
	
}
