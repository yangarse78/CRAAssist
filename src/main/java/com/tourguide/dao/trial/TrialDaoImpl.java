package com.tourguide.dao.trial;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrialDaoImpl implements TrialDao {


	@Autowired
	 private SessionFactory sessionFactory;
	
	
	
}
