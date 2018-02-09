package com.topmobile.bean;

import java.util.List;

import com.topmobile.entry.MobileModel;
import com.topmobile.util.Strings;

/**
 * 手机型号添加参数封装bean
 *
 * @author wgl
 * @date 2017年12月5日 上午11:50:54
 */
public class RequestParamModel {

	private String name ;
	private int ram ;
	
	private int rom ;
	
	private String color ;
	private double price ;
	//
	private List<String> malls ;
	
	public RequestParamModel() {}

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getMalls() {
		return malls;
	}

	public void setMalls(List<String> malls) {
		this.malls = malls;
	}
	/**
	 * 检查各个参数的合法性并返回错误描述
	 * @return
	 */
	public String volidate(){
		String errorMsg = null;
		if(Strings.isEmpty(name)){
			errorMsg = "名称不能为空";
		}else if(Strings.isEmpty(color)){
			errorMsg = "颜色不能为空";
		}else if(malls==null||malls.isEmpty()){
			errorMsg = "请选择至少一个商城";
		}
		return errorMsg;
	}
	
	public MobileModel toMobileModelBean(){
		MobileModel bean = new MobileModel();
		bean.setName(name);
		bean.setRam(ram);
		bean.setRom(rom);
		bean.setPrice(price);
		bean.setColor(color);
		return bean;
	}
	
}
