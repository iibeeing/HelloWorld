package com.proxy.dynamic.notinterface;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void save(User user) {
		System.out.println("User saved!");
	}

}
