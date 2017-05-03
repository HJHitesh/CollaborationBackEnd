package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;



public interface FriendDAO {
	
	public boolean saveOrupdate(Friend	friend);

	// public boolean update(ChatForum ChatForum);

	public boolean deleteById(String id);

	public Friend getFriendById(String id);

	public Friend getFriendByName(String name);

	public List<Friend> list();


}
