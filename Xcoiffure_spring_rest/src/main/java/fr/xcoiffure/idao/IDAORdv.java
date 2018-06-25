package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.xcoiffure.model.Rdv;

public interface IDAORdv extends JpaRepository<Rdv, Integer> {
	
	public List<Rdv> findByClientNomContains(String nom);
	
	@Query("select r from Rdv r where r.client.id = :id")
	List<Rdv> findAllByClient(@Param("id") Integer id);
}
