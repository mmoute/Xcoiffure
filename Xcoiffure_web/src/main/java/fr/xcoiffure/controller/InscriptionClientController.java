package fr.xcoiffure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.xcoiffure.idao.IDAOAdresse;
import fr.xcoiffure.idao.IDAOClient;
import fr.xcoiffure.model.Adresse;
import fr.xcoiffure.model.Client;

@Controller
public class InscriptionClientController {


	@Autowired
	IDAOClient daoClient;
	
	@Autowired
	IDAOAdresse daoAdresse;
	

	 //LISTER  LISTER  LISTER  LISTER  LISTER  LISTER 

	/* LISTER  LISTER  LISTER  LISTER  LISTER  LISTER*/

	@RequestMapping("/client")
	public String ListerClient(Model model) {
		model.addAttribute("clients", daoClient.findAll());
		return "client";
	}
	
	@RequestMapping("/adresse")
	public String ListerAdresse(Model model) {
		model.addAttribute("adresses", daoAdresse.findAll());
		return "adresse";
	}
	
	/* MODIFIER  MODIFIER  MODIFIER  MODIFIER  MODIFIER  MODIFIER */

	 //MODIFIER  MODIFIER  MODIFIER  MODIFIER  MODIFIER  MODIFIER 

	@GetMapping("/modifierclient")
	public String ModifierClient(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			Model model) {
		model.addAttribute("client");
		return "modifierclient";
	}

	@PostMapping("/modifierclient")
	public String ModifierClient(
			@ModelAttribute Client client) {
	daoClient.save(client);
	return"redirect:/client";
	}
	
	@GetMapping("/modifieradresse")
	public String ModifierAdresse(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			Model model) {
		model.addAttribute("adresse");
		return "modifieradresse";
	}
	
	@PostMapping("/modifieradresse")
	public String ModifierAdresse(
			@ModelAttribute Adresse adresse) {
	daoAdresse.save(adresse);
	return"redirect:/adresse";
	}

	 //AJOUTER  AJOUTER  AJOUTER  AJOUTER  AJOUTER  AJOUTER 

	@GetMapping("/inscriptionclient")
	public String AjouterClient(Model model) {
		return "inscriptionclient";
	}

	@PostMapping("/inscriptionclient")
	public String AjouterClient(
			@ModelAttribute Client client,
			@ModelAttribute Adresse adresse) {
		daoClient.save(client);
		daoAdresse.save(adresse);
		
		return "redirect:/accueil";
	}

	 //SUPPRIMER  SUPPRIMER  SUPPRIMER  SUPPRIMER  SUPPRIMER  SUPPRIMER 

	@GetMapping("/supprimerclient")
	public String SupprimerClient(@RequestParam int id) {
		daoClient.deleteById(id);
		return "redirect:/client";
	}

	@GetMapping("/supprimeradresse")
	public String SupprimerAdresse(@RequestParam int id) {
		daoClient.deleteById(id);
		return "redirect:/adresse";
	}

}
