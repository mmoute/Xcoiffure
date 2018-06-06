package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import fr.xcoiffure.model.Client;


@Controller
public class AccountController {

	
	@GetMapping("/inscription")
	public String SeConnecter() {
		return "Inscription";
	}

	
	@PostMapping("iInscription")
	public String SeConnecter(@ModelAttribute  Client Client) {

		System.out.println(Client);
		System.out.println("Username : " + Client.getUsername() + " Password : " + Client.getPassword());

		return "redirect:/acceuil";
	}
}
