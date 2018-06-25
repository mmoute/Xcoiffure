package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.xcoiffure.model.Employes;

public interface IDAOEmployes extends JpaRepository<Employes, Integer> {

	@Query("select distinct em from Employes em left join fetch em.rdvs rdv")
	List<Employes> findAllWithEmployesRdv();
	
	@Query("select em from Employes em where em.entreprise.id = :id")
	List<Employes> findAllByEntreprise(@Param("id") Integer id);

}
