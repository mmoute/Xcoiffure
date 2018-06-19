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

import fr.formation.dao.IDAOProduit;
import fr.formation.model.Produit;
import fr.formation.model.Views;

@RestController
@RequestMapping("/produit")
public class EntrepriseRestController {
	
	@Autowired
	private IDAOProduit daoProduit;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewProduit.class)
	public List<Produit> list() {
		return daoProduit.findAllWithProduits();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewProduit.class)
	public Produit find(@PathVariable Integer id) {
		Optional<Produit> obj =  daoProduit.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le produit n'a pas été trouvé");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewProduit.class)
	public void create(@RequestBody Produit produit) {
		daoProduit.save(produit);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public void update(@RequestBody Produit produit) {
		daoProduit.save(produit);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public void delete(@PathVariable Integer id) {
		daoProduit.deleteById(id);
	}
	
}
