package com.cnksi.demo;

import com.jfinal.core.Controller;

/**
 * 前台采用dwz框架 
 * 
 * @author joe
 *
 */
public class IndexController extends Controller
{
	/**
	 * 登录页面
	 */
	public void index()
	{
		render("/dwz/login.jsp");
	}

	public void login()
	{
		redirect("/home");
	}

	public void home()
	{
		render("/dwz/index.jsp");
	}
}
