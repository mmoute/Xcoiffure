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

import fr.xcoiffure.idao.IDAOEmployes;
import fr.xcoiffure.model.Employes;
import fr.xcoiffure.model.Views;



@RestController
@RequestMapping("/employes")
public class EmployesRestController {
	
	@Autowired
	private IDAOEmployes daoEmployes;

	@GetMapping("/entreprise/{id}")
	@ResponseBody
	@JsonView(Views.ViewEmployes.class)
	public List<Employes> listEmployes() {
		return daoEmployes.findAllWithEmployesRdv();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewEmployes.class)
	public Employes find(@PathVariable Integer id) {
		Optional<Employes> obj =  daoEmployes.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'employes n'a pas été trouvé");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewEmployes.class)
	public void create(@RequestBody Employes employes) {
		daoEmployes.save(employes);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewEmployes.class)
	public void update(@RequestBody Employes employes) {
		daoEmployes.save(employes);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewEmployes.class)
	public void delete(@PathVariable Integer id) {
		daoEmployes.deleteById(id);
	}
	
}
