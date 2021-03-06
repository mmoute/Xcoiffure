package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.xcoiffure.model.Adresse;

public interface IDAOAdresse extends JpaRepository<Adresse, Integer> {
	
//	@Query("select distinct a from Adresse a left join fetch a.adresseClients c")
//	List<Adresse> findAllWithAdressesClients();
//	
//	@Query("select distinct a from Adresse a left join fetch a.adresseEntreprises e")
//	List<Adresse> findAllWithAdressesEntreprises();
	
	@Query("select a from Adresse a inner join a.adresseEntreprises ae where ae.id = :id")
	List<Adresse> findAllByEntreprise(@Param("id") Integer id);
	
	@Query("select a from Adresse a inner join a.adresseClients ac where ac.id = :id")
	List<Adresse> findAllByClient(@Param("id") Integer id);

}
