/**
 * 
 */
package com.ccip.bank.service;

import java.util.List;

import com.ccip.bank.model.Company;
import com.ccip.bank.model.InvestPotential;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

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
		return dao.paginate(pageNumber, pageSize, "select *", 
				"from en_all_company where concat(IFNULL(cname,''),IFNULL(industry,''),IFNULL(registerAuth,'')) like ?","%"+key+"%");
//		return dao.paginate(pageNumber, pageSize, "select *", 
//				"from curya工商  where concat(IFNULL(公司名称,''),IFNULL(行业,''),IFNULL(start_time,''),IFNULL(登记机关,'')) like ?","%"+key+"%");
//
	}
	
	public Company findById(String id) {
		return dao.findById(id);
	}
			
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	//0426 get all company to warning page @hang
	public Page<Company> paginats_all_company(int pageNumber, int pageSize, String cname){ 
		// 基本SQL语句select a.*,b.school 	
        String sql = "SELECT * FROM en_all_company";
		// 动态条件的SQL语句
        String itemSql = "";
        //通过企业名称进行查询[根据需求待实现]
        itemSql = " where cname like '%" + cname + "%'";
        //System.out.println(itemSql);
		return dao.paginate(pageNumber, pageSize, "SELECT distinct(company_name),cname,code,industry ","FROM en_all_company, en_news where en_all_company.cname=en_news.company_name and cname like ?","%"+cname+"%"); 		
	}

	
	
	//search company by  统一信用代码
	public Company getByCreditNum (String creditCode) {
		return  dao.findFirst("select * from en_all_company where code = ?" , creditCode);
	}
	// 获取新闻数据 
	public List<Company>  getBynews (String cname) {
		return  dao.find("select publish_date,news_title,source,content  from en_news where company_name = ? limit 6" , cname);
	}
	
	//获取法律诉讼
	public Page<Company> paginats(int pageNumber, int pageSize,String code){
		
		String select = "select * ";
		String sqlExceptSelect = "from 法律诉讼 where code = ?  order by date desc";
		return dao.paginate(pageNumber, pageSize, select, sqlExceptSelect, code);
        
    	}
	
	//获取变更信息
	public Page<Company> paginat_change(int pageNumber, int pageSize,String code){
		return dao.paginate(pageNumber, pageSize,"select *","from 变更信息  where code = ?  order by change_date desc" , code);
	        
	    }
	
	//获取财务数据 变为新闻数据
	public Page<Company> paginat_financial(int pageNumber, int pageSize,String name){
		return dao.paginate(pageNumber, pageSize,"select publish_date,news_title,source,content","from en_news   where company_name = ? " , name);
	        
	    }
	
	
	
	
	//获取法院公告
		public Page<Company> paginat_notice(int pageNumber, int pageSize,String code){
			return dao.paginate(pageNumber, pageSize,"select *","from 法院公告  where code = ?" , code);
	        
	    }
		
	//获取被执行人
	public Page<Company> paginat_preson(int pageNumber, int pageSize,String code){
		return dao.paginate(pageNumber, pageSize,"select *","from 被执行人  where code = ?" , code);
			        
		}
	
	//获取开庭公告
		public Page<Company> paginat_session(int pageNumber, int pageSize,String code){
			return dao.paginate(pageNumber, pageSize,"select *","from 开庭公告  where code = ?" , code);
			        
		}

 //知识产权数据
		//获取专利
		public Page<Company> paginat_zhuanli(int pageNumber, int pageSize,String code){
			return dao.paginate(pageNumber, pageSize,"select *","from 专利  where code = ?" , code);
	        
	    	}
		//获取软件著作
			public Page<Company> paginat_soft(int pageNumber, int pageSize,String code){
				return dao.paginate(pageNumber, pageSize,"select *","from 软件著作权   where code = ?" , code);
		        
		    }
		//获取作品著作
		public Page<Company> paginat_works(int pageNumber, int pageSize,String code){
			return dao.paginate(pageNumber, pageSize,"select *","from 作品著作权  where code = ?" , code);
				        
			}
		//获取网站备案
			public Page<Company> paginat_web(int pageNumber, int pageSize,String code){
				return dao.paginate(pageNumber, pageSize,"select *","from 网站备案  where code = ?" , code);
				        
			}
		//商标信息
			public Page<Company> paginat_brand(int pageNumber, int pageSize,String code){
				return dao.paginate(pageNumber, pageSize,"select *","from 商标信息  where code = ?" , code);
				        
			}	
}

