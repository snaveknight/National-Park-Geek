package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class surveyController {

	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String toSurveyPage(Survey survey, ModelMap map) {
		return "survey";
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String tofavoritesPage(@ModelAttribute Survey survey) {
		surveyDao.save(survey);
		return "redirect:/favorites";
	}
	
}
