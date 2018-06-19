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

import fr.xcoiffure.model.Client;
import fr.xcoiffure.model.Views;
import fr.xcoiffure.idao.IDAOClient;

@RestController
@RequestMapping("/client")
public class ClientRestController {
	
	@Autowired
	private IDAOClient daoClient;

	@GetMapping("/adresse")
	@ResponseBody
	@JsonView(Views.ViewClient.class)
	public List<Client> listClientAssocies() {
		return daoClient.findAllWithClientAssocies();
	}
	@GetMapping("/rdv")
	@ResponseBody
	@JsonView(Views.ViewClient.class)
	public List<Client> listeClientRdv() {
		return daoClient.findAllWithClientRdv();
	}
	
	
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewClient.class)
	public Client find(@PathVariable Integer id) {
		Optional<Client> obj =  daoClient.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le client n'a pas été trouvé");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewClient.class)
	public void create(@RequestBody Client client) {
		daoClient.save(client);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public void update(@RequestBody Client client) {
		daoClient.save(client);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public void delete(@PathVariable Integer id) {
		daoClient.deleteById(id);
	}
	
}
