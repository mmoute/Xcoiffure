package fr.xcoiffure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.exceptions.NotFoundException;
import fr.xcoiffure.model.Client;

public interface IDAOClient extends JpaRepository<Client, Integer> {
	
	public Client findByNom(String nom) throws NotFoundException ;

}
