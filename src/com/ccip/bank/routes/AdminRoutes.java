package com.ccip.bank.routes;

import com.ccip.bank.admin.AdminController;
import com.jfinal.config.Routes;

/**
 * @date 2018年3月19日 上午10:52:08 
 */
/**
 * @author Mason
 *
 */
public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add("/admin",AdminController.class);
	}
}

