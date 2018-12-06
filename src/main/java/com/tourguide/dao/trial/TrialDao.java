package com.tourguide.dao.trial;

import java.util.List;

import com.tourguide.model.Trial;

public interface TrialDao {

	List<Trial> getList();

	Trial getByKey(Long id);

	void saveOrUpdate(Trial trial);

	void persist(Trial trial);
}
