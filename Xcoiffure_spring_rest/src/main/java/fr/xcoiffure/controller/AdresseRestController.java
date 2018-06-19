package fr.xcoiffure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

<<<<<<< Updated upstream
=======
import fr.xcoiffure.idao.IDAOAdresse;
import fr.xcoiffure.model.Adresse;
import fr.xcoiffure.model.Views;

>>>>>>> Stashed changes


@RestController
@RequestMapping("/adresse")
public class AdresseRestController {
	
	@Autowired
	private IDAOAdresse daoAdresse;

	@GetMapping("/client/{id}")
	@ResponseBody
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> listAdressesClients() {
		return daoAdresse.findAllWithAdressesClients();
	}
	
	@GetMapping("/entreprise/{id}")
	@ResponseBody
	@JsonView(Views.ViewAdresse.class)
	public List<Adresse> listAdressesEntreprises() {
		return daoAdresse.findAllWithAdressesEntreprises();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewAdresse.class)
	public Adresse find(@PathVariable Integer id) {
		Optional<Adresse> obj =  daoAdresse.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'adresse n'a pas été trouvé");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewAdresse.class)
	public void create(@RequestBody Adresse adresse) {
		daoAdresse.save(adresse);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewAdresse.class)
	public void update(@RequestBody Adresse adresse) {
		daoAdresse.save(adresse);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewAdresse.class)
	public void delete(@PathVariable Integer id) {
		daoAdresse.deleteById(id);
	}
	
}
