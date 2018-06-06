package DAO;

import exceptions.NotFoundException;
import fr.xcoiffure.model.Client;

public interface IDAO_Client extends IDAO<Client> {
	
	public Client findByName(String nom) throws NotFoundException ;

}
