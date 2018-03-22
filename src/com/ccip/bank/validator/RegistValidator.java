package com.ccip.bank.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class RegistValidator extends Validator  {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		//是否为空验证
				validateRequired("uname", "unameMsg", "请输入用户名!");
				validateRequired("pwd", "pwdMsg", "请输入密码!");
				validateRequired("confirmpwd", "confirmMsg", "请再输入一遍密码!");
				validateRequired("verifycode", "vcMsg", "请输入验证码!");
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		
	}

	
}
