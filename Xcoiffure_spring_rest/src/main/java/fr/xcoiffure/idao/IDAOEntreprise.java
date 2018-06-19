package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.xcoiffure.model.Entreprise;

public interface IDAOEntreprise extends JpaRepository<Entreprise, Integer> {
	@Query("select distinct e from Entreprise e left join fetch e.entrepriseAssocies ea")
	List<Entreprise> findAllWithentrepriseAssocies();
}
