package com.techelevator.controller;

import java.util.List;

public interface ParksDao {
	
	public List<Parks> getAllParksInAlphOrder();
	
	public Parks getParkInfoById(String parkCode);

	public List<Weather> getWeatherInfo(String parkCode);
	
//	public String getAdvisoryCondition(String parkCode);

}
