package com.tourguide.dao.user;

import java.util.List;

import com.tourguide.model.User;

public interface UserDao {

	   void save(User user);
	   
	   List<User> list();
}
