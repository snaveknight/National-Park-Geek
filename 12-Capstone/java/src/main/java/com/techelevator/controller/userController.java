package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {
@Autowired
private ParksDao parksDao;
	@RequestMapping({"/", "/parksHomePage"})
	public String showListOfParks(ModelMap map) {
		map.put("parksList", parksDao.getAllParksInAlphOrder());
		return "parksHomePage";
	}
	
}
