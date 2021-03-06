package Xcoiffure_Principal;


import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import DAO.DAO_Adresse;
import DAO.DAO_Client;
import DAO.DAO_Employes;
import DAO.DAO_Rdv;
import DAO.DAO_Service;
import DAO.IDAO_Adresse;
import DAO.IDAO_Client;
import DAO.IDAO_Employes;
import DAO.IDAO_Rdv;
import DAO.IDAO_Service;
import exceptions.NotFoundException;
import fr.xcoiffure.model.*;



public class Principale {

	public static void main(String[] args) throws NotFoundException {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		//RDV
		System.out.println("Saisir nombre correspondant � l'operation :");
		System.out.println("1 = Lister");
		System.out.println("2 = Ajouter");
		System.out.println("3 = Supprimer");
		System.out.println("4 = Trouver");
		System.out.println("5 = R�cuperer les r�servations d'un client");
		int choix = sc.nextInt();
		
		
		IDAO_Adresse daoadresse = new DAO_Adresse();
		IDAO_Client daoclient = new DAO_Client();
		IDAO_Employes daoemployes = new DAO_Employes();
		IDAO_Service daoservice = new DAO_Service();
		IDAO_Rdv daordv = new DAO_Rdv();
				
		switch (choix)
		{
			case 1:
				for (Rdv R1 : daordv.findAll()) {
					System.out.println(R1);
				}
				break;
				
			case 2:
				
				System.out.println("Saisir le nom du Client associ� au Rdv :");
	            String nom = sc.next();
	            Client C2 = daoclient.findByName(nom);
	            
				System.out.println("Saisir l'ID de l'Employe :");
	            int id = sc.nextInt();
	            Employes Em2 = daoemployes.findById(id);
	           
				System.out.println("Saisir l'ID du Service :");
				int id2 = sc.nextInt();
	            Service S2 = daoservice.findById(id);
	            
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
					System.out.println("erreur au niveau de la cr�ation de la date de naissance du client");
					ex.printStackTrace();
				}

				
		        daordv.save(R2);
		       
		        System.out.println("Le Rendez-vous � bien �t� pris en compte !");
				
		        break;
				
		        
			/*case 3:
						
				System.out.println("Saisir le nom du Client pour supprimer son rendez-vous :");
	            String nom = sc.next();
					
				try 
		        {
		            
		            Client C3 = daoclient.findByName(nom);
		            
		            
		            daoclient.delete(C3); 
		     
		            
		            System.out.println("Le rendez vous du client " + nom + " � �t� supprim� !");
		            
		        }
		        
		        catch (NotFoundException ex) 
		        {
		            System.out.println("Le rendez-vous ne peut pas �tre supprimer car le client " + nom + " n'existe pas");
		            ex.printStackTrace();
		        }
				break;
				
			case 4:
				
				try 
		        {
		            System.out.println("Saisir le nom du Client recherch� :");
		            String nom = sc.next();
		            Client C4 = daoclient.findByName(nom);
		            
		            System.out.println("Le client � �t� trouv� !");
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
		            System.out.println("Saisir le nom du Client dont vous voulez afficher les r�servations :");
		            String nom = sc.next();
		            List<Rdv> R5 = daordv.FindAllContainsNom(nom);
		            
		            System.out.println("Le client � �t� trouv� !");
		            System.out.println(R5);
		        }
		        
		   		break;	*/

				default:
				System.out.println("Erreur dans la saisie");

		}
		
		
		//CLIENT				
		System.out.println("Saisir nombre correspondant � l'operation :");
		System.out.println("1 = Lister");
		System.out.println("2 = Ajouter");
		System.out.println("3 = Supprimer");
		System.out.println("4 = Trouver");
		System.out.println("5 = R�cuperer les r�servations d'un client");
		int choix2 = sc.nextInt();
		
		
		
				
		switch (choix2)
		{
			case 1:
				for (Client C1 : daoclient.findAll()) {
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
				
				daoadresse.save(A2);
				 
				 
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
					System.out.println("erreur au niveau de la cr�ation de la date de naissance du client");
					ex.printStackTrace();
				}

		        daoclient.save(C2);
		       
		        
		        C2.setClientAssocies(new ArrayList <Adresse>());
		        C2.getClientAssocies().add(A2);
		        
		       
		        daoclient.save(C2);

				System.out.println("Ajouter");
				break;
				
				
				
			case 3:
				
				//Je r�cup�re le nom saisi
				//Je r�cup�re le Client avec ce nom, avec la m�thode find()
				//Je supprime ce client
								
				try 
		        {
		            System.out.println("Saisir le nom du Client supprimer :");
		            String nom = sc.next();
		            Client C3 = daoclient.findByName(nom);
		            
		            
		           daoclient.delete(C3); 
		     
		            
		            System.out.println("Le client � �t� supprim� !");
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
		            System.out.println("Saisir le nom du Client recherch� :");
		            String nom = sc.next();
		            Client C4 = daoclient.findByName(nom);
		            
		            System.out.println("Le client � �t� trouv� !");
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
		            System.out.println("Saisir le nom du Client dont vous voulez afficher les r�servations :");
		            String nom = sc.next();
		            List<Rdv> R5 = daordv.FindAllContainsNom(nom);
		            
		            System.out.println("Le client � �t� trouv� !");
		            System.out.println(R5);
		        }
		        
		   		break;	

				default:
				System.out.println("Erreur dans la saisie");

		}
			
		sc.close();


	}
}
