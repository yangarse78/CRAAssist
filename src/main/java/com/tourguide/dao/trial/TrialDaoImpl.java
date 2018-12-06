package com.tourguide.dao.trial;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.Trial;

@Service
public class TrialDaoImpl extends AbstractDao<Long, Trial> implements TrialDao {

	private static final Logger logger = LoggerFactory.getLogger(TrialDaoImpl.class);
	
	@Override
	public List<Trial> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<Trial> query = getSession().createQuery("from Trial");
		return query.getResultList();
	}

	@Override
	public void persist(Trial trial) {
		logger.debug("Persist - Saving new trial.");
		super.persist(trial);
		Long id = trial.getId();
		//TODO change return type of the method
		logger.debug("New trial Id: {}.", id);
	}



	
}
