package fr.Xcoiffure.principal;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import fr.Xcoiffure.dao.repository.IDAOAdresse;
import fr.Xcoiffure.dao.repository.IDAOCategorie;
import fr.Xcoiffure.dao.repository.IDAOEmployes;
import fr.Xcoiffure.dao.repository.IDAOEntreprise;
import fr.Xcoiffure.dao.repository.IDAOService;
import fr.xcoiffure.model.*;

public class Generator {
	@Autowired
	private IDAOAdresse daoAdresse;
	@Autowired
	private IDAOEntreprise daoEntreprise;
	@Autowired
	private IDAOEmployes daoEmployes;
	@Autowired
	private IDAOCategorie daoCategorie;
	@Autowired
	private IDAOService daoService;

	public void run(String[] args) {

		Adresse A2 = new Adresse();
		A2.setNomRue("Paris");
		A2.setCodePostal("75013");
		A2.setVille("Paris");
		// A2.setAdresseEntreprises(adresseEntreprises); MANYtoMANY
		daoAdresse.save(A2);

		Entreprise En1 = new Entreprise();
		En1.setNom_gerant("Chang");
		En1.setNom_societe("Coiffure d'Asie");
		// En1.setEntrepriseAdresses(entrepriseAdresses); MANYtoMANY
		// En1.setServices(services);
		// En1.setEmployes(employes);
		daoEntreprise.save(En1);
		En1.setEntrepriseAssocies(new ArrayList<Adresse>());
		En1.getEntrepriseAssocies().add(A2);
		daoEntreprise.save(En1);

		Employes Em1 = new Employes();
		Em1.setPrenom("Tsing");
		Em1.setNom("Tao");
		Em1.setEntreprise(En1);
		daoEmployes.save(Em1);

		Categorie Ca1 = new Categorie();
		Ca1.setNom("Coiffure");
		// Ca1.setServices(services);
		daoCategorie.save(Ca1);

		Service S1 = new Service();
		S1.setNom("Shampooing + soin + coupe + brushing");
		S1.setPrix(32);
		S1.setTemps(30);
		S1.setEntreprise(En1);
		S1.setCategorie(Ca1);
		daoService.save(S1);

	}
}
