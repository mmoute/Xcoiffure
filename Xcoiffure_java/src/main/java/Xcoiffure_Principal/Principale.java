package Xcoiffure_Principal;


import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DAO.DAO_Client;
import DAO.IDAO_Client;
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
		System.out.println("5 = Modifier");
		int choix = sc.nextInt();
		
		IDAO_Client daoclient = new DAO_Client();
				
		switch (choix)
		{
			case 1:
				for (Client C1 : daoclient.findAll()) {
					System.out.println(C1);
				}
				break;
			case 2:
				Client C2 = new Client();
				
				System.out.println("Saisir votre prenom");
				C2.setPrenom(sc.next());
				
				System.out.println("Saisir votre nom");
				C2.setNom(sc.next());
				
				
								
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
		            C2.setNaissance(formatter2.format(date));
		            saisie1 = true;
		        }
		        
		        catch (Exception ex) 
		        {
		        	ex.printStackTrace();
		        	sc.next();
		        	System.out.println("Erreur de saisie");
		        }
		        }
		        
		        
				System.out.println("Saisir votre rue");
				C2.getClientAdresses();(sc.next());
				
				System.out.println("Saisir votre code postal");
				C2.getAdresse().setCodePostal(sc.next());
				
				System.out.println("Saisir votre ville");
				C2.getAdresse().setVille(sc.next());
				
				
				//SAUVEGARDE DU NOUVEAU CHAT
				dao.save(C2);
				
				
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
		            Client monClient = dao.find(nom);
		            
		          dao.delete(monClient);
		            
		            System.out.println("Le client à été supprimé !");
		            System.out.println(monClient);
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
		            Client monClient = dao.find(nom);
		            
		            System.out.println("Le client à été trouvé !");
		            System.out.println(monClient);
		        }
		        
		        catch (NotFoundException ex) 
		        {
		            System.out.println("Le client n'existe pas");
		            ex.printStackTrace();
		        }
				break;
				
			case 5:
				try 
		        {
		            System.out.println("Saisir le nom du Client à modifier :");
		            String nom = sc.next();
		            Client monClient = dao.find(nom);
		            
		            System.out.println("Saisir les modification !");
		            
		            System.out.println("Saisir votre prenom");
		            monClient.setPrenom(sc.next());
					
					System.out.println("Saisir votre nom");
					monClient.setNom(sc.next());
					
					
									
			        DateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
			        Format formatter4 = new SimpleDateFormat("yyyy-MM-dd");
			        
			        boolean saisie2 = false;
			        
			        while (saisie2 == false) {        
			        try 
			        {		        
			        	System.out.println("Saisir votre date de naissance => dd/MM/yyyy :");
			            Date date = formatter3.parse(sc.next());
			            System.out.println("La date = " + date);
			            
			            System.out.println("La date = " + formatter4.format(date));
			            monClient.setNaissance(formatter4.format(date));
			            saisie2 = true;
			        }
			        
			        catch (Exception ex) 
			        {
			        	ex.printStackTrace();
			        	sc.next();
			        	System.out.println("Erreur de saisie");
			        }
			        }
			        
			        
					System.out.println("Saisir votre rue");
					monClient.getAdresse().setNomRue(sc.next());
					
					System.out.println("Saisir votre code postal");
					monClient.getAdresse().setCodePostal(sc.next());
					
					System.out.println("Saisir votre ville");
					monClient.getAdresse().setVille(sc.next());
					
					
					//SAUVEGARDE DU NOUVEAU CHAT
					dao.modifier(monClient);
					
					
					System.out.println("Modifié");
					break;
		            
		            
		            
		            
		
		        }
		        
		        catch (NotFoundException ex) 
		        {
		            System.out.println("Le client n'existe pas");
		            ex.printStackTrace();
		        }
				break;
				
				
				default:
				System.out.println("Erreur dans la saisie");
				
				
	

		}
			
		sc.close();


	}

}
