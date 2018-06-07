package fr.xcoiffure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RdvController {
		
		@GetMapping("/ajoutrdv")
		public String AjouterRdv() {
			return "ajoutrdv";
		}
}
