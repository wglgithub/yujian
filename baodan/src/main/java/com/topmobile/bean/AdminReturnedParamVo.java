package com.topmobile.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AdminReturnedParamVo {

	
	@NotEmpty
	private String id ; //报单id
	@Min(value=0)
	@NotNull
	private Integer shippingPrice ; //出货价 单位 分
	@NotNull
	private Integer returned ;  //给下级回款 单位 分
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(Integer shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public Integer getReturned() {
		return returned;
	}
	public void setReturned(Integer returned) {
		this.returned = returned;
	}
	
	
}
