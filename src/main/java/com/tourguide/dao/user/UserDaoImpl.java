package com.tourguide.dao.user;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<Long, UserDaoImpl>implements UserDao {

	 
	@Override
	public void save(User user) {
		getSession().save(user);
	}

	@Override
	public List<User> list() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = getSession().createQuery("from User");
		return query.getResultList();
	}

}
