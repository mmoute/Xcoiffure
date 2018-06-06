package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.xcoiffure.model.Client;


@Controller
public class ConnexionController {

	
	@GetMapping("/connexion")
	public String SeConnecter() {
		return "connexion";
	}

	
	@PostMapping("/connexion")
	public String SeConnecter(@ModelAttribute Client client) {

		System.out.println("Username : " + client.getUsername() + " Password : " + client.getPassword());

		return "redirect:/accueil";
	}
}

