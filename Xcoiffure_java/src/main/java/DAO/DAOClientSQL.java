package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.sopra.classe.Client;




public class DAOClientSQL implements DAOClient {
	
	@Override
	public Client save(Client obj) {
		try {
			//CONNEXION AU SERVEUR MY SQL
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reservation", "root", "");
			//CREATION DU STATEMENT PREPARE
			
			PreparedStatement myStatement =
					myConnection.prepareStatement("INSERT INTO Adresse (ADR_RUE, ADR_CP, ADR_VILLE) VALUES (?, ?, ?)");
					myStatement.setString(1, obj.getAdresse().getNomRue());
					myStatement.setString(2, obj.getAdresse().getCodePostal());
					myStatement.setString(3, obj.getAdresse().getVille());
					myStatement.execute();
			
					
					Statement myStatement2 = myConnection.createStatement();
					ResultSet myResult = myStatement2.executeQuery("SELECT ADR_ID FROM Adresse ORDER BY ADR_ID DESC LIMIT 0, 1");
					
					int ADR_ID_CLT = 0;
					
					while(myResult.next()) {
						System.out.println(myResult.getString("ADR_ID"));
						ADR_ID_CLT = myResult.getInt("ADR_ID");
						}
					
			PreparedStatement myStatement3 =
					myConnection.prepareStatement("INSERT INTO Client (CLT_ID_ADRESSE, CLT_NOM, CLT_PRENOM, CLT_DATE_NAISSANCE) VALUES (?, ?, ?, ?)");
					myStatement3.setInt(1, ADR_ID_CLT );
					myStatement3.setString(2, obj.getNom());
					myStatement3.setString(3, obj.getPrenom());
					myStatement3.setString(4, obj.getNaissance());
					myStatement3.execute();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return obj;
	}
	
	
	@Override
	public Client modifier(Client obj) {
		try {
			//CONNEXION AU SERVEUR MY SQL
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reservation", "root", "");
			//CREATION DU STATEMENT PREPARE
			
			Statement myStatement = myConnection.createStatement();
			myStatement.executeUpdate("UPDATE Adresse SET ADR_RUE='" + obj.getAdresse().getNomRue()+ "', "
							+ "ADR_CP ='" + obj.getAdresse().getCodePostal() + "', "
							+ "ADR_VILLE ='" + obj.getAdresse().getVille() + "'"
							+ "WHERE ADR_ID =" + obj.getAdresse().getId());

					
			Statement myStatement3 = myConnection.createStatement();
					myStatement3.executeUpdate("UPDATE Client SET CLT_ID_ADRESSE ='" + obj.getAdresse().getId() + "', "
						+ "CLT_NOM ='" + obj.getNom() + "', "
						+ "CLT_PRENOM = '" + obj.getPrenom() + "', "
						+ "CLT_DATE_NAISSANCE = '" + obj.getNaissance()+ "'"
						+ "WHERE CLT_ID =" + obj.getId());
					
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return obj;
	}
	
	
	@Override
	public boolean delete(Client obj) {
		
	
		try {
			//CONNEXION AU SERVEUR MY SQL
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reservation", "root", "");
			//CREATION DU STATEMENT PREPARE
			
			Statement myStatement2 = myConnection.createStatement();
			myStatement2.execute("DELETE FROM Client WHERE CLT_NOM = '" + obj.getNom() + "'");
			
			return true;
		}
			

			
			catch(Exception e) {
				e.printStackTrace();
			}
		
			return false;
		}
	

	
	
	@Override
	public Client find(String nom) throws exceptions.NotFoundException {	
		
		Client Cl = new Client ();
		
		try {
			//CONNEXION AU SERVEUR MY SQL
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reservation", "root", "");
			//CREATION DU STATEMENT PREPARE
			
			Statement myStatement2 = myConnection.createStatement();
			ResultSet myResult = myStatement2.executeQuery("SELECT * FROM Client WHERE CLT_NOM = '" + nom + "'" );
//			myStatement2.execute(String.format("SELECT * FROM Client WHERE CLT_NOM = '%s'", nom));
			
			
			while(myResult.next()) {
				//AFFECTATION DE SES ATTRIBUTS
				Cl.setId(myResult.getInt("CLT_ID"));
				Cl.setPrenom(myResult.getString("CLT_PRENOM"));
				Cl.setNom(myResult.getString("CLT_NOM"));
				Cl.getAdresse().setId(myResult.getInt("CLT_ID_ADRESSE"));
				}
		}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		return Cl ;
	}



	@Override
	public List<Client> findAll() {
		
		ArrayList<Client> listeClient = new ArrayList<Client>();
		
		try {
			
			//CONNEXION AU SERVEUR MY SQL
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reservation",  "root", "");
			
			//CREATION DU STATEMENT ET EXECUTION DE LA REQUETTE
			Statement myStatement = myConnection.createStatement();
			ResultSet myResult1 = myStatement.executeQuery("SELECT CLT_NOM, CLT_PRENOM FROM Client");
			
			
			//PARCOURS DE TOUS LES ENREGISTREMENT DE LA TABLE
			while(myResult1.next()) {
			
				//CREATION DU Client
				Client Cl = new Client ();
			
				//AFFECTATION DE SES ATTRIBUTS
				Cl.setPrenom(myResult1.getString("CLT_PRENOM"));
				Cl.setNom(myResult1.getString("CLT_NOM"));
				
				//AJOUT DU Client DANS LA LISTE
				listeClient.add(Cl);
				}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return listeClient;
	}

}
