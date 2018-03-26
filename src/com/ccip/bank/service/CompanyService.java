/**
 * 
 */
package com.ccip.bank.service;

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
	
	public Page<Company> paginate(int pageNumber, int pageSize) {
		return dao.paginate(pageNumber, pageSize, "select *", "from en_companyinfo order by id asc");
	}
	
	public Company findById(int id) {
		return dao.findById(id);
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	
	
}

