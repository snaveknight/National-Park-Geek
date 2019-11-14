package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {
	@Autowired
	private ParksDao parksDao;

	@RequestMapping("/")
	public String showListOfParks(ModelMap map) {
		map.put("parksList", parksDao.getAllParksInAlphOrder());
		return "parksHomePage";
	}
	
	@RequestMapping("/parkDetails")
	public String showDetails(@RequestParam String parkCode, 
			ModelMap map) {
		map.put("parkslist",parksDao.getParkInfoById(parkCode.toUpperCase() ));
		map.put("weatherList", parksDao.getWeatherInfo(parkCode.toUpperCase()));
//		map.put("advisory", parksDao.getAdvisoryCondition(foreCast));
		return "parkDetails";
	}
	
	@RequestMapping("/celsiusDetails")
	public String showCelDetails(@RequestParam String parkCode, ModelMap map) {
		map.put("parkslist",parksDao.getParkInfoById(parkCode.toUpperCase() ));
		map.put("weatherList", parksDao.getWeatherInfo(parkCode.toUpperCase()));
//		map.put("advisory", parksDao.getAdvisoryCondition(foreCast));
		return "celsiusDetails";
	}
	

}
