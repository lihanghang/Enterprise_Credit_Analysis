package Validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator  {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("username", "usernameMsg", "请输入用户名");
		validateRequiredString("password", "passwordMsg", "请输入密码");
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.keepPara("username");
		c.keepPara("password");
		c.render("");
	}

	
}
