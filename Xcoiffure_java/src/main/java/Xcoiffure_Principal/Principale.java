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
import DAO.DAO_Rdv;
import DAO.IDAO_Adresse;
import DAO.IDAO_Client;
import DAO.IDAO_Rdv;
import exceptions.NotFoundException;
import model.*;



public class Principale {

	public static void main(String[] args) {

		
		
		Scanner sc = new Scanner(System.in);
		
		
		/*
		//RDV
		System.out.println("Saisir nombre correspondant à l'operation :");
		System.out.println("1 = Lister");
		System.out.println("2 = Ajouter");
		System.out.println("3 = Supprimer");
		System.out.println("4 = Trouver");
		System.out.println("5 = Modifier");
		int choix0 = sc.nextInt();
		
		DAORdv dao = new DAORdvSQL();
		
		switch (choix0)
		{
			case 1:
				break;
			case 2:
				Rdv R = new Rdv();
				
				System.out.println("Saisir votre prenom");
				R.setPrenom(sc.next());
				
				System.out.println("Saisir votre nom");
				R.setNom(sc.next());
				
				
								
		        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		        Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		        
		        boolean saisie1 = false;
		        
		        while (saisie1 == false) {        
		        try 
		        {		        
		        	System.out.println("Saisir votre date de naissance => dd/MM/yyyy :");
		            Date date = formatter.parse(sc.next());
		            System.out.println("La date = " + date);
		            
		            System.out.println("La date = " + formatter2.format(date));
		            R.setDate();(formatter2.format(date));
		            saisie1 = true;
		        }
		        
		        catch (Exception ex) 
		        {
		        	ex.printStackTrace();
		        	sc.next();
		        	System.out.println("Erreur de saisie");
		        }
		        
		        case 3:
					break;
					
		        case 4:
					break;
					
		        case 5:
					break;
		        }
		        
		
				
				//SAUVEGARDE DU NOUVEAU CHAT
				dao.save(R);
				
				
				System.out.println("Ajouter");
				break;
				
		}
		
		*/
		
		
		//CLIENT				
		System.out.println("Saisir nombre correspondant à l'operation :");
		System.out.println("1 = Lister");
		System.out.println("2 = Ajouter");
		System.out.println("3 = Supprimer");
		System.out.println("4 = Trouver");
		System.out.println("5 = Récuperer les réservations d'un client");
		int choix = sc.nextInt();
		
		
		IDAO_Adresse daoadresse = new DAO_Adresse();
		IDAO_Client daoclient = new DAO_Client();
		IDAO_Rdv daordv = new DAO_Rdv();
				
		switch (choix)
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
					System.out.println("erreur au niveau de la création de la date de naissance du client");
					ex.printStackTrace();
				}

		        daoclient.save(C2);
		       
		        
		        C2.setClientAssocies(new ArrayList <Adresse>());
		        C2.getClientAssocies().add(A2);
		        
		       
		        daoclient.save(C2);

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
		            Client C3 = daoclient.findByName(nom);
		            
		            
		           daoclient.delete(C3); 
		     
		            
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
		        
		   		break;	

				default:
				System.out.println("Erreur dans la saisie");

		}
			
		sc.close();


	}

}
