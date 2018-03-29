package com.ccip.bank.admin;

import com.jfinal.core.Controller;

public class AdminController extends Controller {

	 public void index(){
			
		 redirect("/admin/index/index.html");
		
	 }
	 public void  login(){
		 
		 render("login/login.html");				
		
		 
	 }
}
