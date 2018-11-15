package com.tourguide.service.user;

import java.util.List;

import com.tourguide.model.User;


public interface UserService {
	   
	void save(User user);
	   
	List<User> list();
}
