package com.cnksi.demo.domain;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User>
{
	private static final long serialVersionUID = 1L;

	private static User userDao = null;

	public static User dao()
	{
		if (userDao == null)
		{
			userDao = new User();
		}

		return userDao;
	}

}
