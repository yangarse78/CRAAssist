package com.tourguide.service.trial;

import java.util.List;

import com.tourguide.model.Trial;

public interface TrialService {

	List<Trial> getList();

	void save(Trial trial);

	Trial getTrialById(Long id);
}
