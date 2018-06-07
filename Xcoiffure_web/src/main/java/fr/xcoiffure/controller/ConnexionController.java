package fr.xcoiffure.controller;

import javax.servlet.http.HttpSession;

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
	  public String SeConnecter(@ModelAttribute Client client, HttpSession session) {
		  session.setAttribute("username", client.getUsername());

		return "redirect:/accueil";
	}
	

}

