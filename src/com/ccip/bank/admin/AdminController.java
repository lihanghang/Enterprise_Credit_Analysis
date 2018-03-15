package com.ccip.bank.admin;

import com.jfinal.core.Controller;

public class AdminController extends Controller {

	 public void index(){
			
		render("login/login.html");				
		
	 }
	 public void  login(){
		 
		 render("index/index.html");
		 
	 }
}
