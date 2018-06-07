package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AccueilController {

	
	@GetMapping("/accueil")
	public String SeConnecter() {
		return "accueil";
	}
	
	@PostMapping("/accueil")
	public String directionrdv() {

		return "redirect:/ajoutrdv";
	}
}