package Validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class RegistValidator extends Validator  {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequired("en_user.name", "nameErrMsg", "请填写用户名！");
        validateRequired("en_user.pwd", "pwdErrMsg", "请填写密码！");
        validateRequired("en_user.reg.confirm", "confirmErrMsg", "请填写确认密码！");
        //validateRequired("reg.yzm", "yzmErrMsg", "请填写验证码！");
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
	}

	
}
