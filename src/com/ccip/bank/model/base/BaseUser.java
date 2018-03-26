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
@SuppressWarnings("serial")
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setUname(java.lang.String uname) {
		set("username", uname);
	}

	public java.lang.String getUname() {
		return get("username");
	}

	public void setTrueName(java.lang.String trueName) {
		set("true_name", trueName);
	}

	public java.lang.String getTrueName() {
		return get("true_name");
	}

	public void setPwd(java.lang.String pwd) {
		set("passwd", pwd);
	}

	public java.lang.String getPwd() {
		return get("passwd");
	}

	public void setDecId(java.lang.Long decId) {
		set("dec_id", decId);
	}

	public java.lang.Long getDecId() {
		return get("dec_id");
	}

	public void setMediaPath(java.lang.String mediaPath) {
		set("media_path", mediaPath);
	}

	public java.lang.String getMediaPath() {
		return get("media_path");
	}

	public void setJoinWork(java.lang.String joinWork) {
		set("join_work", joinWork);
	}

	public java.lang.String getJoinWork() {
		return get("join_work");
	}

	public void setUsersex(java.lang.String usersex) {
		set("usersex", usersex);
	}

	public java.lang.String getUsersex() {
		return get("usersex");
	}

	public void setMzId(java.lang.Long mzId) {
		set("mz_id", mzId);
	}

	public java.lang.Long getMzId() {
		return get("mz_id");
	}

	public void setZzmmId(java.lang.Long zzmmId) {
		set("zzmm_id", zzmmId);
	}

	public java.lang.Long getZzmmId() {
		return get("zzmm_id");
	}

	public void setPDegreeSchool(java.lang.String pDegreeSchool) {
		set("p_degree_school", pDegreeSchool);
	}

	public java.lang.String getPDegreeSchool() {
		return get("p_degree_school");
	}

	public void setPEduSchool(java.lang.String pEduSchool) {
		set("p_edu_school", pEduSchool);
	}

	public java.lang.String getPEduSchool() {
		return get("p_edu_school");
	}

	public void setPDegreeId(java.lang.Integer pDegreeId) {
		set("p_degree_id", pDegreeId);
	}

	public java.lang.Integer getPDegreeId() {
		return get("p_degree_id");
	}

	public void setPEduId(java.lang.Integer pEduId) {
		set("p_edu_id", pEduId);
	}

	public java.lang.Integer getPEduId() {
		return get("p_edu_id");
	}

	public void setFEduSchool(java.lang.String fEduSchool) {
		set("f_edu_school", fEduSchool);
	}

	public java.lang.String getFEduSchool() {
		return get("f_edu_school");
	}

	public void setFDegreeSchool(java.lang.String fDegreeSchool) {
		set("f_degree_school", fDegreeSchool);
	}

	public java.lang.String getFDegreeSchool() {
		return get("f_degree_school");
	}

	public void setFDegreeId(java.lang.Integer fDegreeId) {
		set("f_degree_id", fDegreeId);
	}

	public java.lang.Integer getFDegreeId() {
		return get("f_degree_id");
	}

	public void setFEduId(java.lang.Integer fEduId) {
		set("f_edu_id", fEduId);
	}

	public java.lang.Integer getFEduId() {
		return get("f_edu_id");
	}

	public void setCard(java.lang.String card) {
		set("card", card);
	}

	public java.lang.String getCard() {
		return get("card");
	}

	public void setAreaId(java.lang.String areaId) {
		set("area_id", areaId);
	}

	public java.lang.String getAreaId() {
		return get("area_id");
	}

	public void setAddress(java.lang.String address) {
		set("address", address);
	}

	public java.lang.String getAddress() {
		return get("address");
	}

	public void setCompany(java.lang.String company) {
		set("company", company);
	}

	public java.lang.String getCompany() {
		return get("company");
	}

	public void setYsjj(java.lang.String ysjj) {
		set("ysjj", ysjj);
	}

	public java.lang.String getYsjj() {
		return get("ysjj");
	}

	public void setHealth(java.lang.String health) {
		set("health", health);
	}

	public java.lang.String getHealth() {
		return get("health");
	}

	public void setRegDate(java.lang.String regDate) {
		set("reg_date", regDate);
	}

	public java.lang.String getRegDate() {
		return get("reg_date");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}
	public void setType(java.lang.Integer type) {
		set("type", type);
	}
	public java.lang.Integer getType() {
		return get("type");
	}

	public void setBirth(java.util.Date birth) {
		set("birth", birth);
	}

	public java.util.Date getBirth() {
		return get("birth");
	}

	public void setPhotoPath(java.lang.String photoPath) {
		set("photo_path", photoPath);
	}

	public java.lang.String getPhotoPath() {
		return get("photo_path");
	}

	public void setTechnicalPosition(java.lang.String technicalPosition) {
		set("technical_position", technicalPosition);
	}

	public java.lang.String getTechnicalPosition() {
		return get("technical_position");
	}

	public void setCompanyTel(java.lang.String companyTel) {
		set("company_tel", companyTel);
	}

	public java.lang.String getCompanyTel() {
		return get("company_tel");
	}

	public void setSocioPartTime(java.lang.String socioPartTime) {
		set("socio_part_time", socioPartTime);
	}

	public java.lang.String getSocioPartTime() {
		return get("socio_part_time");
	}

	public void setTelephone(java.lang.String telephone) {
		set("telephone", telephone);
	}

	public java.lang.String getTelephone() {
		return get("telephone");
	}

	public void setAwards(java.lang.String awards) {
		set("awards", awards);
	}

	public java.lang.String getAwards() {
		return get("awards");
	}

	public void setOpinion(java.lang.String opinion) {
		set("opinion", opinion);
	}

	public java.lang.String getOpinion() {
		return get("opinion");
	}

	public void setBusinessAchievement(java.lang.String businessAchievement) {
		set("business_achievement", businessAchievement);
	}

	public java.lang.String getBusinessAchievement() {
		return get("business_achievement");
	}

	public void setEmail(java.lang.String email) {
		set("email", email);
	}

	public java.lang.String getEmail() {
		return get("email");
	}

	public void setQqwx(java.lang.String qqwx) {
		set("qqwx", qqwx);
	}

	public java.lang.String getQqwx() {
		return get("qqwx");
	}

}
