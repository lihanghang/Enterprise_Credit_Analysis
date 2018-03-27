package com.ccip.bank.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * 
 */
/**
 * @date 2018年3月22日 下午5:03:52 
 */
/**
 * @author Mason
 *
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseCompany<M extends BaseCompany<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setCname(java.lang.String cname) {
		set("cname", cname);
		return (M)this;
	}
	
	public java.lang.String getCname() {
		return getStr("cname");
	}
	
	public M setCapital(java.lang.String capital) {
		set("capital", capital);
		return (M)this;
	}
	
	public java.lang.String getCapital() {
		return getStr("capital");
	}
	public M setStart_time(java.lang.String start_time) {
		set("start_time", start_time);
		return (M)this;
	}
	
	public java.lang.String getStart_time() {
		return getStr("start_time");
	}

	public M setIndustry(java.lang.String industry) {
		set("industry", industry);
		return (M)this;
	}
	
	public java.lang.String getIndustry() {
		return getStr("industry");
	}
	public M setStatus(java.lang.String status) {
		set("status", status);
		return (M)this;
	}
	
	public java.lang.String getStatus() {
		return getStr("status");
	}
	
	public M setOrganizateNum(java.lang.String organizateNum) {
		set("organizateNum", organizateNum);
		return (M)this;
	}
	
	public java.lang.String getOrganizateNum() {
		return getStr("organizateNum");
	}
	
	//企业地址
	public M setRegAddress(java.lang.String regAddress) {
		set("regAddress", regAddress);
		return (M)this;
	}
	
	public java.lang.String getRegAddress() {
		return getStr("regAddress");
	}
	
}
