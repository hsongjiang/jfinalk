package com.cnksi.demo.service;

import com.cnksi.core.jfinal.BaseService;
import com.cnksi.demo.domain.User;

public class UserService extends BaseService<User>
{
	private static UserService userService = null;

	public static UserService service()
	{
		if (userService == null)
		{
			userService = new UserService();
		}

		return userService;
	}

	@Override
	public User getDao()
	{
		return User.dao();
	}

}
