package com.topmobile.entry;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.topmobile.util.DateUtils;
/**
 * 实体父类
 *
 * @author wgl
 * @date 2017年7月12日 下午6:22:20
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class BaseEntry implements Serializable {

	private static final long serialVersionUID = 6803228834798593383L;
	@Id
	@Column(name="c_id",length=64)
	protected String id ;
	
	protected long ts ;
	@Column(length=30)
	protected String dateStr ;
	@Column(length=30)
	protected String updateDate ;
	
	protected int flag ;
	
	public BaseEntry() {
		autoGenerateTime();
		setId();
	}
	public String setId(){
		setId(UUID.randomUUID().toString().replaceAll("-", ""));
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntry other = (BaseEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	/**
	 * 自动生成指定时间
	 * @param time
	 */
	public void autoGenerateTime(long time) {
		setTs(time);
		setDateStr(DateUtils.timeFormat(time));
		setUpdateDate(dateStr);
	}
	/**
	 * 自动生成时间
	 * @param time
	 */
	public void autoGenerateTime() {
		autoGenerateTime(System.currentTimeMillis());
	}
	
}
