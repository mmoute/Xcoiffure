package DAO;

import java.util.List;

import fr.xcoiffure.model.Rdv;

public interface IDAO_Rdv extends IDAO<Rdv> {

	public List<Rdv> FindAllContainsNom(String nom);
	
}
