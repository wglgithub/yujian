package com.topmobile.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 手机配置
 *
 * @author wgl
 * @date 2017年8月6日 下午11:13:36
 */
@Entity
@Table(name="w_mobileconfig")
public class MobileConfig extends BaseEntry{
	/**
	 * 机型
	 */
	@Column
	private String model ;
	/**
	 * 颜色
	 */
	@Column
	private String color ;
	/**
	 * 内存大小 单位g
	 */
	@Column
	private int memory ;
	/**
	 * 存储
	 */
	@Column
	private int storage ;
	
	public MobileConfig() {}

	public MobileConfig(String model, String color, int memory, int storage) {
		super();
		this.model = model;
		this.color = color;
		this.memory = memory;
		this.storage = storage;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	public int getMemory() {
		return memory;
	}


	public void setMemory(int memory) {
		this.memory = memory;
	}


	public int getStorage() {
		return storage;
	}


	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	
}
