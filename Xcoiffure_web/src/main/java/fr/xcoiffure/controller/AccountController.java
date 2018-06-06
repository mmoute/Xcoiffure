package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.modele1.Produit;

import fr.formation.model4.Utilisateur;


@Controller
public class AccountController {

	
	@GetMapping("/login")
	public String SeConnecter() {
		return "login";
	}

	
	@PostMapping("/login")
	public String SeConnecter(@ModelAttribute  Utilisateur utilisateur) {

		System.out.println(utilisateur);
		System.out.println("Username : " + utilisateur.getUsername() + " Password : " + utilisateur.getPassword());

		return "redirect:/produit";
	}
	
/*	
	@PostMapping("/login")
	public String SeConnecter(
			@RequestParam(value = "nomuser", required = false) String nom,
			@RequestParam(value = "passeuser", required = false) String  password) {

		System.out.println(nom);
		System.out.println(password);
		
		return "redirect:/produit";
	}*/

}
