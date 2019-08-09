package com.velone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccueilController {

	@GetMapping("/accueil")
	public String sayHello(Model model,
			@RequestParam(name="name", required=false, defaultValue="VelOne") String name) {
		model.addAttribute("name", name);
		return "accueil";
	}
}