package com.jp.coronavirustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jp.coronavirustracker.services.CoronaVirusDataService;

@Controller
public class HomeController {

	@Autowired
	private CoronaVirusDataService coronaVirusDataService;

	@GetMapping("/")
	public String getStats(Model model) {

		model.addAttribute("locationStats", coronaVirusDataService.getLocationStatsList());
		model.addAttribute("allStats", coronaVirusDataService.getAllStats());

		return "home";
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public String searchCountryStats(@RequestParam(value = "country", required = false) String country, Model model) {
		
		System.out.println("COUNTRY IS : " +country);
		model.addAttribute("locationStats", coronaVirusDataService.getCountryStats(country));
		
		return "home";
		
		
	}

}
