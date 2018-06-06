package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntrepriseController {

	
	@GetMapping("/inscriptionentreprise")
	public String inscrireclient() {
		return "inscriptionentreprise";
	}
}