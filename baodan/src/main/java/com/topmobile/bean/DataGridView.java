package com.topmobile.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.topmobile.entry.BaoDanMall;
import com.topmobile.util.ApiResponseCode;
/**
 * jquery easyui datagrid数据返回封装
 *
 * @author wgl
 * @date 2017年12月3日 下午11:36:33
 */
public class DataGridView implements Serializable{

	private static final long serialVersionUID = -25916066154137058L;
	/**
	 * 处理结果 1=成功,其他情况可自定义
	 */
	private int status ;
	/**
	 * 处理结果的文字描述
	 */
	private String msg ;
	//总条数
	private int total ;
	//分页大小 大于0
	private int size =1;
	//当前页 从1开始
	private int page =1;
	//查询数据
	private List<Object> rows ;
	
	public DataGridView() {}
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	private DataGridView(Page pageObj) {
		this.status = ApiResponseCode.SUCCESS_OK;
		this.page = pageObj.getNumber();
		this.size = pageObj.getSize();
		this.total = (int) pageObj.getTotalElements();
		this.rows = pageObj.getContent();
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	@SuppressWarnings("rawtypes")
	public static DataGridView fromSpringPage(Page pageObj) {
		
		return new DataGridView(pageObj);
	}
	
	
}
