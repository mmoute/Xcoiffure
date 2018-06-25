package fr.xcoiffure.idao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.exceptions.NotFoundException;

import fr.xcoiffure.model.Client;

public interface IDAOClient extends JpaRepository <Client, Integer> {
	
//	@Query("select distinct c from Client c left join fetch c.clientAssocies ca")
//	List<Client> findAllWithClientAssocies();
//	
//	@Query("select distinct c from Client c left join fetch c.rdvs rdv")
//	List<Client> findAllWithClientRdv();
	
public Client findByNom(String nom) throws NotFoundException ;

}
