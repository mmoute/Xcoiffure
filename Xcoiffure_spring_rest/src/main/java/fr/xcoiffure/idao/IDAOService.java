package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.xcoiffure.model.Service;

public interface IDAOService extends JpaRepository<Service, Integer> {

	@Query("select distinct s from Service s left join fetch s.rdvs rdv")
	List<Service> findAllWithrdv();
	
}
