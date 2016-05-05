package com.proxy.dynamic.notinterface;
import javax.annotation.Resource;

import com.proxy.dynamic.notinterface.IUserDAO;
import com.proxy.dynamic.notinterface.User;

public class UserService {
	private IUserDAO userDAO;

	public void add(User user)
	 {
	  userDAO.save(user);
	 }

	public IUserDAO getUserDAO(){
	  return userDAO;
	 }

	@Resource
	 //@Autowired
	 public void setUserDAO(IUserDAO userDAO){
	  this.userDAO=userDAO;
	 }
}
