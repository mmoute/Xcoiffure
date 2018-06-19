package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.xcoiffure.exceptions.NotFoundException;

import fr.xcoiffure.model.Client;

public interface IDAOClient extends JpaRepository <Client, Integer> {
	@Query("select distinct c from Client c left join fetch c.clientAssocies ca")
	List<Client> findAllWithClientAssocies();
	
public Client findByNom(String nom) throws NotFoundException ;

}
