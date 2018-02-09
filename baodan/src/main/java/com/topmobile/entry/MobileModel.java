package com.topmobile.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 手机型号表
 *
 * @author wgl
 * @date 2017年7月16日 下午10:41:20
 */
@Entity
@Table(name="w_mobilemodel")
public class MobileModel extends BaseEntry{

	@Column
	private String name ;
	//内存
	@Column
	private int ram ;
	//存储
	@Column
	private int rom ;
	@Column
	private String color ;
	//官方价格
	@Column
	private double price ;
	@Column
	private String remark ;
	//上架商城的名称，格式"name1,name2,name3,..."
	@Column(columnDefinition="text",length=1024)
	private String malls ;

	public MobileModel() {
		// TODO Auto-generated constructor stub
	}
	public MobileModel(String name2) {
		this.name= name2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getRom() {
		return rom;
	}
	public void setRom(int rom) {
		this.rom = rom;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setMalls(String malls) {
		this.malls = malls;
	}
	public String getMalls() {
		return malls;
	}
	
}
