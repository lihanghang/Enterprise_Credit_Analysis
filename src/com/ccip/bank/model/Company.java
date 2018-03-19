package com.ccip.bank.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Company extends Model<Company>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
    // ����һ��ȫ�ֲ����ı���
    public final static Company dao = new Company();
/*    public Page<Company> paginate(int pageNumber, int pageSize) {
    	//index ��ҳ
    	return dao.paginate(pageNumber, pageSize, "select company_name", "from company_news_data group by company_name");
	}
    public List<Company> news(String a,String b,int news_id) {
		return news("SELECT news_title,content,news_type,publish_data,source ","FROM company_news_data WHERE id = ?",news_id);
	}
    public List<Company> total(String c, String d) {
		return total ("SELECT count(distinct(company_name)) as total","FROM company_news_data ");
	}*/
}
