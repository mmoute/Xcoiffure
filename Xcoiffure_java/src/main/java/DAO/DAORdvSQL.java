package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.sopra.classe.Rdv;

public class DAORdvSQL implements DAORdv {

	@Override
	public Rdv save(Rdv obj) {
		try {
			//CONNEXION AU SERVEUR MY SQL
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reservation", "root", "");
			//CREATION DU STATEMENT PREPARE
			int idClient = obj.getClient().getId();
			int idService = obj.getService().getId();
			int idEmployes = obj.getEmployes().getId();
			
			PreparedStatement myStatement =
					myConnection.prepareStatement("INSERT INTO Rdv (RDV_ID_CLIENT, RDV_ID_SERVICES, RDV_ID_EMPLOYES, RDV_VALIDEE, RDV_DATE) VALUES (?, ?, ?, ?, ?)");
					myStatement.setInt(1, idClient);
					myStatement.setInt(2, idService);
					myStatement.setInt(3, idEmployes);
					myStatement.setBoolean(4, obj.isValide());
					myStatement.setString(5, obj.getDate());
					myStatement.execute();
					
		}
			
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return obj;
	}

	@Override
	public boolean delete(Rdv obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rdv find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rdv> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rdv modifier(Rdv obj) {
		// TODO Auto-generated method stub
		return null;
	}



}
