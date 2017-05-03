package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {
	
	public boolean saveOrupdate(User user);
	
	//public boolean update(User user);
	
	public List<User> list();
	
	public User get(String id);
	
	public boolean isValidate(String id ,String password);

}
