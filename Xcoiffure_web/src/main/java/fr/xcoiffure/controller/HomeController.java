package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/home")
public class HomeController {
	
/*	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("nomutilisateur", "Max");
		return "home";
	}*/
	
	@GetMapping({"/", "/{username}" }) /*si j'enlève requestMapping /home au dessus : @GetMapping({"/home", "/home/{username}" })  request mapping*/	
	public String home(
			@PathVariable(value="username", required=false) String username, 
			@RequestParam(value="id", required=false, defaultValue= "8"  ) int id, 
			Model model) {
	model.addAttribute("username", username);
	model.addAttribute( "id", id);
	return "home";
	}
	
}