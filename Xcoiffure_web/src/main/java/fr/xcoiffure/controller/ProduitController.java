package fr.xcoiffure.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.modele1.Fournisseur;
import com.sopra.modele1.Produit;

import fr.xcoiffure.idao.IDAOFournisseur;
import fr.xcoiffure.idao.IDAOProduit;

@Controller
public class ProduitController {

	@Autowired
	IDAOProduit daoProduit;
	
	@Autowired
	IDAOFournisseur daoFournisseur;

	
	@RequestMapping("/produit")
	public String ListerProduit(Model model) {
		model.addAttribute("produits", daoProduit.findAll());

		return "produit";
	}
	
	
	@ModelAttribute("fournisseurs")
	public List<Fournisseur> getFournisseur(){
		return daoFournisseur.findAll();
	}

	
	@GetMapping("/modifierproduit")
	public String ModifierProduit(
			@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("produit", daoProduit.findById(id).get());
		return "ajoutproduit";
	}
	
	@PostMapping("/modifierproduit")
	public String ModifierProduit(@Valid @ModelAttribute Produit produit, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("Le produit n'a pas été validé ...");
			return "ajoutproduit";
			}
		daoProduit.save(produit);

		return "redirect:/produit";
	}
	

	
/*	@PostMapping("/modifierproduit")
	public String ModifierProduit(
			@RequestParam int id,
			@RequestParam(value = "nomproduit", required = false) String libelle,
			@RequestParam(value = "prixproduit", required = false) double prix) {
		Produit p = new Produit();
		p.setId(id);
		p.setLibelle(libelle);
		p.setPrix(prix);
		
		daoProduit.save(p);

		return "redirect:/produit";
	}*/
	
	
	@GetMapping("/ajoutproduit")
	public String AjouterProduit(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("fournisseurs", daoFournisseur.findAll());
		return "ajoutproduit";
	}

	@PostMapping("/ajoutproduit")
	public String AjouterProduit(@Valid @ModelAttribute Produit produit, BindingResult result, Model model ) {
		if (result.hasErrors()) {
			System.out.println("Le produit n'a pas été validé ...");
			return "ajoutproduit";
			}
		
		daoProduit.save(produit);
		return "redirect:/produit";
	}

	
	
/*	@PostMapping("/ajoutproduit")
	public String AjouterProduit(
			@RequestParam(value = "nomproduit", required = false) String libelle,
			@RequestParam(value = "prixproduit", required = false) double prix) {
		Produit p = new Produit();
		p.setLibelle(libelle);
		p.setPrix(prix);
		
		daoProduit.save(p);

		return "redirect:/produit";
	}*/

	
	@GetMapping("/supprimerproduit")
	public String SupprimerProduit(
			@RequestParam(value = "id", required = false) int id) {
		daoProduit.deleteById(id);
		
		return "redirect:/produit";
	}
}
