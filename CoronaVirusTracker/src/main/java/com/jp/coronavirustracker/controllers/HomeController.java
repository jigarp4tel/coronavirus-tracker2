package com.jp.coronavirustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
