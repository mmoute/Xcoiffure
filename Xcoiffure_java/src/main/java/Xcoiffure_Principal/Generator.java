package Xcoiffure_Principal;

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

public class Generator {
	public static void main(String[] args) {

		IDAO_Adresse ajouterAdresse = new DAO_Adresse();

		Adresse A2 = new Adresse();
		A2.setNomRue("Paris");
		A2.setCodePostal("75013");
		A2.setVille("Paris");

		// A2.setAdresseEntreprises(adresseEntreprises);

		ajouterAdresse.save(A2);

		
		IDAO_Service ajouterService = new DAO_Service();

		Service S1 = new Service();
		S1.setNom("Shampooing + soin + coupe + brushing");
		S1.setPrix(32);
		S1.setTemps(30);
		S1.setEntreprise(En1);
		
		S1.setRdvs(rdvs);
		S1.setCategorie(categorie);

		ajouterService.save(S1);
		
		IDAO_Categorie ajouterCategorie = new DAO_Categorie();

		Categorie Ca1 = new Categorie();
		Ca1.setNom("Coiffure");
		Ca1.setServices(S1);

		ajouterCategorie.save(Ca1);
		
		
		IDAO_Entreprise ajouterEntreprise = new DAO_Entreprise();

		Entreprise En1 = new Entreprise();
		En1.setNom_gerant("Chang");
		En1.setNom_societe("Coiffure d'Asie");

		// En1.setFournisseurAdresses(fournisseurAdresses);
		// En1.setServices(services);

		ajouterEntreprise.save(En1);

		IDAO_Employes ajouterEmployes = new DAO_Employes();

		Employes Em1 = new Employes();
		Em1.setPrenom("Tsing");
		Em1.setNom("Tao");

		ajouterEmployes.save(Em1);


	}
}
