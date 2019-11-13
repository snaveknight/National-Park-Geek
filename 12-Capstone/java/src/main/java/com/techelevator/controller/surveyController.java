package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class surveyController {

	@Autowired
	private ParksDao parksDao;
	
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String toSurveyPage(Survey survey, ModelMap map, Model modelHolder) {
		List<Parks> allParks = parksDao.getAllParksInAlphOrder();
		map.put("parks", allParks);
		if (!modelHolder.containsAttribute("survey")) {
			modelHolder.addAttribute("survey", new Survey());
		} 
		return "survey";
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String tofavoritesPage(@Valid @ModelAttribute Survey survey,
			BindingResult result,
			RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey",
					result);
			flash.addFlashAttribute("survey", survey);
			return "redirect:/";
		}
		surveyDao.save(survey);
		return "redirect:/favorites";
	}
	
	@RequestMapping(path= "/favorites", method = RequestMethod.GET)
	public String getListOfFavoriteCampsites(Survey survey, ModelMap map) {
		List<Parks> favParks = parksDao.getAllParksInFavOrder();
		map.put("parks", favParks);
		return "favorites";
	}
	
}