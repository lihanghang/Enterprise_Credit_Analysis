
package com.ccip.bank.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * @date 2018年4月28日 下午3:32:19 
 */
/**
 * @author Mason
 *
 */
public class BaseCompanyInfo <M extends BaseCompanyInfo<M>> extends Model<M> implements IBean {

	private static final long serialVersionUID = 1L;
	public Integer getId() {
		return get("id");
	}
	public void setId(int id) {
		set("id", id);
	}
	public String getName() {
		return get("name");
	}
	public void setName(String name) {
		set("name", name);
	}
	public String getState() {
		return get("state");
	}
	public void setState(String state) {
		set("state", state);
	}
	public String getRemark() {
		return get("remark");
	}
	public void setRemark(String remark) {
		set("remark", remark);
	}
	
}

