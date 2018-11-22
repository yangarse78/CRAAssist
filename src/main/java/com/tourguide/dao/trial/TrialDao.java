package com.tourguide.dao.trial;

import java.util.List;

import com.tourguide.model.Trial;

public interface TrialDao {

	   List<Trial> getList();

	   void save(Trial trial);

	   Trial getTrialById(Long id);
}
