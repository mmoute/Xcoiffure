package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class ClientController {

	
	@GetMapping("/inscriptionclient")
	public String inscrireclient() {
		return "inscriptionclient";
	}
}