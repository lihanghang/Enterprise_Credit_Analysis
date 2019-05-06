package com.ccip.bank.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator  {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("login.name", "UnameErrMsg", "请输入用户名！");
		validateRequiredString("login.password", "PwdErrMsg", "请输入密码！");
		//validateRequiredString("login.verifycode", "yzmErrMsg", "请输入验证码！");
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.redirect("/user/login.html");
	}

	
}
