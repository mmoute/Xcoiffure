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

import fr.xcoiffure.idao.IDAOAdresse;
import fr.xcoiffure.idao.IDAOEmployes;
import fr.xcoiffure.idao.IDAOEntreprise;
import fr.xcoiffure.idao.IDAOService;
import fr.xcoiffure.model.Adresse;
import fr.xcoiffure.model.Employes;
import fr.xcoiffure.model.Entreprise;
import fr.xcoiffure.model.Service;
import fr.xcoiffure.model.Views;


@RestController
@RequestMapping("/entreprise")
@CrossOrigin(origins = "*")
public class EntrepriseRestController {
	
	@Autowired
	private IDAOEntreprise daoEntreprise;
	
	@Autowired
	private IDAOService daoService;
	
	@Autowired
	private IDAOEmployes daoEmployes;
	
	@Autowired
	private IDAOAdresse daoAdresse;

//	@GetMapping("")
//	@ResponseBody
//	@JsonView(Views.ViewEntreprise.class)
//	public List<Entreprise> listentrepriseAssocies() {
//		return daoEntreprise.findAllWithentrepriseAssocies();
//	}
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewEntreprise.class)
	public List<Entreprise> listentrepriseAssocies() {
		return daoEntreprise.findAll();
	}
	
	@GetMapping("/{id}/adresse")
	@ResponseBody
	@JsonView(Views.ViewEntreprise.class)
	public List<Adresse> listadresse(@PathVariable Integer id) {
		return daoAdresse.findAllByEntreprise(id);
	}
	
	@GetMapping("/{id}/employes")
	@ResponseBody
	@JsonView(Views.ViewEntreprise.class)
	public List<Employes> listemployes(@PathVariable Integer id) {
		return daoEmployes.findAllByEntreprise(id);
	}
	
	@GetMapping("/{id}/service")
	@ResponseBody
	@JsonView(Views.ViewService.class)
	public List<Service> listservices(@PathVariable Integer id) {
		return daoService.findAllByEntreprise(id);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewEntreprise.class)
	public Entreprise find(@PathVariable Integer id) {
		Optional<Entreprise> obj =  daoEntreprise.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'entreprise n'a pas été trouvé");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewEntreprise.class)
	public void create(@RequestBody Entreprise entreprise) {
		daoEntreprise.save(entreprise);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewEntreprise.class)
	public void update(@RequestBody Entreprise entreprise) {
		daoEntreprise.save(entreprise);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewEntreprise.class)
	public void delete(@PathVariable Integer id) {
		daoEntreprise.deleteById(id);
	}
	
}
