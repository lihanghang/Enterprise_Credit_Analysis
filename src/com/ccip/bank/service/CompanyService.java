/**
 * 
 */
package com.ccip.bank.service;

import java.util.List;

import com.ccip.bank.model.Company;
import com.jfinal.plugin.activerecord.Page;

/**
 * @date 2018年3月26日 下午8:00:59 
 */
/**
 * @author Mason
 *
 */
public class CompanyService {

	
	private static final Company dao = new Company().dao();
	
	public Page<Company> paginate(int pageNumber, int pageSize, String key) {
		return dao.paginate(pageNumber, pageSize, "select *", "from en_companyinfo where concat(IFNULL(cname,''),IFNULL(industry,''),IFNULL(start_time,'')) like ?","%"+key+"%");
	}
	
	public Company findById(int id) {
		return dao.findById(id);
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	
	//search company by organizateNum0327
	public Company getByOrgNum (String orgNum) {

		return  dao.findFirst("select * from en_companyinfo where organizateNum = ?" , orgNum);
	}
	
}

