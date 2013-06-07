package com.cnksi.demo.controller;

import com.cnksi.core.jfinal.BaseControllerDwz;
import com.cnksi.core.jfinal.BaseService;
import com.cnksi.demo.domain.User;
import com.cnksi.demo.service.UserService;

public class UserController extends BaseControllerDwz<User>
{

	@Override
	protected BaseService<User> getService()
	{
		return UserService.service();
	}

}
