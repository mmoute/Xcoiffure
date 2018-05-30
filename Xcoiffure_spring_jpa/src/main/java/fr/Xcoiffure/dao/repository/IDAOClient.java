package fr.Xcoiffure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.Xcoiffure.exceptions.NotFoundException;
import model.Client;

public interface IDAOClient extends JpaRepository<Client, Integer> {
	
	public Client findByNom(String nom) throws NotFoundException ;

}
