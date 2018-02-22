package com.topmobile.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 管理员账号
 *
 * @author wgl
 * @date 2017年7月23日 上午10:01:50
 */
@Table(name="admin_user")
@org.hibernate.annotations.Table(appliesTo="admin_user",comment="行情系统管理员账号表")
@Entity
public class AdminUser extends BaseEntry{
	private static final long serialVersionUID = -8781106402838092128L;

	@Column(nullable=false)
	private String account ;
	@Column(columnDefinition="varchar(255) COMMENT '姓名 '")
	private String name ;
	@Column(nullable=false)
	private String pwd ;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
