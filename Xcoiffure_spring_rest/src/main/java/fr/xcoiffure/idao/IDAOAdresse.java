package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.xcoiffure.model.Adresse;

public interface IDAOAdresse extends JpaRepository<Adresse, Integer> {
	
	@Query("select distinct a from Adresse a left join fetch a.adresseClients c")
	List<Adresse> findAllWithAdressesClients();
	
	@Query("select distinct a from Adresse a left join fetch a.adresseEntreprises e")
	List<Adresse> findAllWithAdressesEntreprises();

}
