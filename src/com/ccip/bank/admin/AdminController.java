package com.ccip.bank.admin;

import com.jfinal.core.Controller;

public class AdminController extends Controller {

	 public void index(){
			
		 redirect("index.html");
		
	 }
	 public void  login(){
		 
		/* render("login.html");	*/					
		 
	 }
	 
	 public void Userlist(){
		 
		 render("/admin/user/member-list.html");
	 }
}
