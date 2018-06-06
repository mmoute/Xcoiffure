package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcceuilController {

	
	@GetMapping("/acceuil")
	public String SeConnecter() {
		return "acceuil";
	}
}