package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {

	@RequestMapping("/")
	public String showListOfParks() {
		return "parksHomePage";
	}
}
