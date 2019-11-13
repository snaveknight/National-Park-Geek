package com.techelevator.controller;

import java.util.List;

public interface SurveyDao {
	
	public void save(Survey survey);

	public List<Parks> getAllParksInFavOrder();
}
