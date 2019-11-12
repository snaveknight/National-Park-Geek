package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {
	@Autowired
	private ParksDao parksDao;

	@RequestMapping("/")
	public String showListOfParks(ModelMap map) {
		map.put("parksList", parksDao.getAllParksInAlphOrder());
		return "parksHomePage";
	}
	
	@RequestMapping("/detailsPage")
	public String showDetails(ModelMap map) {
		map.put("details", parksDao.getParkInfoById());
		return "detailsPage";
	}
	

}
