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

import fr.xcoiffure.idao.IDAORdv;
import fr.xcoiffure.model.Rdv;
import fr.xcoiffure.model.Views;


@RestController
@RequestMapping("/rdv")
@CrossOrigin(origins = "*")
public class RdvRestController {
	
	@Autowired
	private IDAORdv daoRdv;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewRdv.class)
	public List<Rdv> list() {
		return daoRdv.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewRdv.class)
	public Rdv find(@PathVariable Integer id) {
		Optional<Rdv> obj =  daoRdv.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le rdv n'a pas été trouvé");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewRdv.class)
	public void create(@RequestBody Rdv rdv) {
		daoRdv.save(rdv);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewRdv.class)
	public void update(@RequestBody Rdv rdv) {
		daoRdv.save(rdv);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewRdv.class)
	public void delete(@PathVariable Integer id) {
		daoRdv.deleteById(id);
	}
	
}
