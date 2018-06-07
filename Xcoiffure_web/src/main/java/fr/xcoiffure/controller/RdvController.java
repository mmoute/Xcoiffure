package fr.xcoiffure.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class RdvController {
		
		@GetMapping("/ajoutrdv")
		public String SeConnecter() {
			return "ajoutrdv";
		}
}
