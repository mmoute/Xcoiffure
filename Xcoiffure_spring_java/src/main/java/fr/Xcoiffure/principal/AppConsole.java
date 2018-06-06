package fr.Xcoiffure.principal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;


import fr.Xcoiffure.dao.repository.IDAOAdresse;
import fr.Xcoiffure.dao.repository.IDAOCategorie;
import fr.Xcoiffure.dao.repository.IDAOClient;
import fr.Xcoiffure.dao.repository.IDAOEmployes;
import fr.Xcoiffure.dao.repository.IDAOEntreprise;
import fr.Xcoiffure.dao.repository.IDAORdv;
import fr.Xcoiffure.dao.repository.IDAOService;
import fr.Xcoiffure.exceptions.NotFoundException;
import fr.xcoiffure.model.Adresse;
import fr.xcoiffure.model.Client;
import fr.xcoiffure.model.Employes;
import fr.xcoiffure.model.Rdv;
import fr.xcoiffure.model.Service;



public class AppConsole
{

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
	@Autowired
	private IDAOClient daoClient;
	@Autowired
	private IDAORdv daoRdv;
	
	
	public void run(String[] args) throws NotFoundException {
		

		Scanner sc = new Scanner(System.in);
		
		
		//CLIENT				
				System.out.println("Saisir nombre correspondant à l'operation concernat un client :");
				System.out.println("1 = Lister");
				System.out.println("2 = Ajouter");
				System.out.println("3 = Supprimer");
				System.out.println("4 = Trouver");
				System.out.println("5 = Récuperer les réservations d'un client");
				int choix2 = sc.nextInt();
				
						
				switch (choix2)
				{
					case 1:
						for (Client C1 : daoClient.findAll()) {
							System.out.println(C1);
						}
						break;
						
					case 2:
						Client C2 = new Client();
						Adresse A2 = new Adresse();
						
						System.out.println("Saisir votre rue");
						A2.setNomRue(sc.next());
						
						System.out.println("Saisir votre code postal");
						A2.setCodePostal(sc.next());
						
						System.out.println("Saisir votre ville");
						A2.setVille(sc.next());
						
						daoAdresse.save(A2);
						 
						 
						System.out.println("Saisir votre prenom");
						C2.setPrenom(sc.next());
						
						System.out.println("Saisir votre nom");
						C2.setNom(sc.next());
						
						System.out.println("Saisir votre date de naissance dd-MM-yyyy");
						DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						try {
							C2.setNaissance(formatter.parse(sc.next()));

						} 
						catch (Exception ex) {
							System.out.println("erreur au niveau de la création de la date de naissance du client");
							ex.printStackTrace();
						}

				        daoClient.save(C2);
				       
				        
				        C2.setClientAssocies(new ArrayList <Adresse>());
				        C2.getClientAssocies().add(A2);
				        
				       
				        daoClient.save(C2);

						System.out.println("Ajouter");
						break;
						
						
						
					case 3:
						
						//Je récupère le nom saisi
						//Je récupère le Client avec ce nom, avec la méthode find()
						//Je supprime ce client
										
						try 
				        {
				            System.out.println("Saisir le nom du Client supprimer :");
				            String nom = sc.next();
				            Client C3 = daoClient.findByNom(nom);
				            
				            
				           daoClient.delete(C3); 
				     
				            
				            System.out.println("Le client à été supprimé !");
				            System.out.println(C3);
				        }
				        
				        catch (NotFoundException ex) 
				        {
				            System.out.println("Le client n'existe pas");
				            ex.printStackTrace();
				        }
						break;
						
					case 4:
						
						try 
				        {
				            System.out.println("Saisir le nom du Client recherché :");
				            String nom = sc.next();
				            Client C4 = daoClient.findByNom(nom);
				            
				            System.out.println("Le client à été trouvé !");
				            System.out.println(C4);
				        }
				        
				        catch (NotFoundException ex) 
				        {
				            System.out.println("Le client n'existe pas");
				            ex.printStackTrace();
				        }
						break;
						
					case 5:
						
						{
				            System.out.println("Saisir le nom du Client dont vous voulez afficher les réservations :");
				            String nom = sc.next();
				            List<Rdv> R5 = daoRdv.findByClientNomContains(nom);
				            
				            System.out.println("Le client à été trouvé !");
				            System.out.println(R5);
				        }
				        
				   		break;	

						default:
						System.out.println("Erreur dans la saisie");

				}
		
		
		
		
		
		//RDV
		System.out.println("Saisir nombre correspondant à l'operation concernant un rdv:");
		System.out.println("1 = Lister");
		System.out.println("2 = Ajouter");
		System.out.println("3 = Supprimer");
		System.out.println("4 = Trouver");
		System.out.println("5 = Récuperer les réservations d'un client");
		int choix = sc.nextInt();

				
		switch (choix)
		{
			case 1:
				for (Rdv R1 : daoRdv.findAll()) {
					System.out.println(R1);
				}
				break;
				
			case 2:
				
				System.out.println("Saisir le nom du Client associé au Rdv :");
	            String nom = sc.next();
	            Client C2 = daoClient.findByNom(nom);
	            
				System.out.println("Saisir l'ID de l'Employe :");
	            int id = sc.nextInt();
	            Employes Em2 = daoEmployes.findById(id).get();
	           
				System.out.println("Saisir l'ID du Service :");
				int id2 = sc.nextInt();
	            Service S2 = daoService.findById(id).get();
	            
	            Rdv R2 = new Rdv();
	            
	            R2.setClient(C2);
	            R2.setEmployes(Em2);
	            R2.setService(S2);
	            
				
				System.out.println("Saisir votre date de Rdv dd-MM-yyyy");
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				try {
					R2.setDate(formatter.parse(sc.next()));

				} 
				catch (Exception ex) {
					System.out.println("erreur au niveau de la création de la date de naissance du client");
					ex.printStackTrace();
				}

				
		        daoRdv.save(R2);
		       
		        System.out.println("Le Rendez-vous à bien été pris en compte !");
				
		        break;
				
		        
			/*case 3:
						
				System.out.println("Saisir le nom du Client pour supprimer son rendez-vous :");
	            String nom = sc.next();
					
				try 
		        {
		            
		            Client C3 = daoclient.findByName(nom);
		            
		            
		            daoclient.delete(C3); 
		     
		            
		            System.out.println("Le rendez vous du client " + nom + " à été supprimé !");
		            
		        }
		        
		        catch (NotFoundException ex) 
		        {
		            System.out.println("Le rendez-vous ne peut pas être supprimer car le client " + nom + " n'existe pas");
		            ex.printStackTrace();
		        }
				break;
				
			case 4:
				
				try 
		        {
		            System.out.println("Saisir le nom du Client recherché :");
		            String nom = sc.next();
		            Client C4 = daoclient.findByName(nom);
		            
		            System.out.println("Le client à été trouvé !");
		            System.out.println(C4);
		        }
		        
		        catch (NotFoundException ex) 
		        {
		            System.out.println("Le client n'existe pas");
		            ex.printStackTrace();
		        }
				break;
				
			case 5:
				
				{
		            System.out.println("Saisir le nom du Client dont vous voulez afficher les réservations :");
		            String nom = sc.next();
		            List<Rdv> R5 = daordv.FindAllContainsNom(nom);
		            
		            System.out.println("Le client à été trouvé !");
		            System.out.println(R5);
		        }
		        
		   		break;	*/

				default:
				System.out.println("Erreur dans la saisie");

		}
		
			
		sc.close();


	}
}
