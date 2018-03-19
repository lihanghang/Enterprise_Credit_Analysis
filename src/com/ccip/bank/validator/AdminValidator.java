/**
 * 
 */
package com.ccip.bank.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * @date 2018年3月19日 下午3:24:27 
 */
/**
 * @author Mason
 *
 */
public class AdminValidator extends Validator{

	/* (non-Javadoc)
	 * @see com.jfinal.validate.Validator#validate(com.jfinal.core.Controller)
	 */
	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		controller.redirect("/admin/index");
		
	}

	/* (non-Javadoc)
	 * @see com.jfinal.validate.Validator#handleError(com.jfinal.core.Controller)
	 */
	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("admin.name", "LoginNameMsg","请输入用户名！");
		validateRequiredString("admin.pwd", "LoginPwdMsg","请输入密码！");
		validateRequiredString("verifycode", "codeMeg", "请输入验证码！");
		
	}

}

