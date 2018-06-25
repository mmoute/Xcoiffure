package fr.xcoiffure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import fr.xcoiffure.model.Adresse;
import fr.xcoiffure.model.Client;
import fr.xcoiffure.model.Rdv;
import fr.xcoiffure.model.Views;
import fr.xcoiffure.idao.IDAOAdresse;
import fr.xcoiffure.idao.IDAOClient;
import fr.xcoiffure.idao.IDAORdv;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientRestController {
	
	@Autowired
	private IDAOClient daoClient;
	
	@Autowired
	private IDAOAdresse daoAdresse;
	
	@Autowired
	private IDAORdv daoRdv;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewClient.class)
	public List<Client> listClientAssocies() {
		return daoClient.findAll();
	}
	
	@GetMapping("/{id}/adresse")
	@ResponseBody
	@JsonView(Views.ViewClient.class)
	public List<Adresse> listadresse(@PathVariable Integer id) {
		return daoAdresse.findAllByClient(id);
	}
	
	@GetMapping("/{id}/rdv")
	@ResponseBody
	@JsonView(Views.ViewRdv.class)
	public List<Rdv> listeRdvClient(@PathVariable Integer id) {
		return daoRdv.findAllByClient(id);
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
