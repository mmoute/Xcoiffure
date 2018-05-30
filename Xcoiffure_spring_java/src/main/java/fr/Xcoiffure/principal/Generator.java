package Xcoiffure_Principal;

import java.util.ArrayList;

import DAO.DAO_Adresse;
import DAO.DAO_Categorie;
import DAO.DAO_Employes;
import DAO.DAO_Entreprise;
import DAO.DAO_Service;
import DAO.IDAO_Adresse;
import DAO.IDAO_Categorie;
import DAO.IDAO_Employes;
import DAO.IDAO_Entreprise;
import DAO.IDAO_Service;
import model.Adresse;
import model.*;

package fr.Xcoiffure.principal;


import org.springframework.beans.factory.annotation.Autowired;
import fr.formation.dao.repository.IDAOProduit;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class Generator
{
	@Autowired
	private IDAOProduit daoProduit;
	
	public void run(String[] args) {
		//CREATION D'UN FOURNISSEUR
		Fournisseur myFournisseur = new Fournisseur();
		myFournisseur.setId(1);
		
		
		//CREATION D'UN DRONE
		Produit myDrone = new Produit();
		myDrone.setLibelle("GoPRO KARMA");
		myDrone.setPrix(799.99);
		myDrone.setFournisseur(myFournisseur);
		
		daoProduit.save(myDrone);

		
		
		IDAO_Adresse ajouterAdresse = new DAO_Adresse();

		Adresse A2 = new Adresse();
		A2.setNomRue("Paris");
		A2.setCodePostal("75013");
		A2.setVille("Paris");

		// A2.setAdresseEntreprises(adresseEntreprises); MANYtoMANY

		ajouterAdresse.save(A2);

		
		
		IDAO_Entreprise ajouterEntreprise = new DAO_Entreprise();

		Entreprise En1 = new Entreprise();
		En1.setNom_gerant("Chang");
		En1.setNom_societe("Coiffure d'Asie");

		// En1.setEntrepriseAdresses(entrepriseAdresses); MANYtoMANY
		// En1.setServices(services);
		// En1.setEmployes(employes);

		ajouterEntreprise.save(En1);
		
		En1.setEntrepriseAssocies(new ArrayList <Adresse>());
		En1.getEntrepriseAssocies().add(A2);
		
		ajouterEntreprise.save(En1);

		
		
		IDAO_Employes ajouterEmployes = new DAO_Employes();

		Employes Em1 = new Employes();
		Em1.setPrenom("Tsing");
		Em1.setNom("Tao");
		Em1.setEntreprise(En1);

		ajouterEmployes.save(Em1);

		
		
		IDAO_Categorie ajouterCategorie = new DAO_Categorie();

		Categorie Ca1 = new Categorie();
		Ca1.setNom("Coiffure");

		//Ca1.setServices(services);
		
		ajouterCategorie.save(Ca1);

		
		
		IDAO_Service ajouterService = new DAO_Service();

		Service S1 = new Service();
		S1.setNom("Shampooing + soin + coupe + brushing");
		S1.setPrix(32);
		S1.setTemps(30);
		S1.setEntreprise(En1);
		S1.setCategorie(Ca1);

		ajouterService.save(S1);

		
		



	}
}
