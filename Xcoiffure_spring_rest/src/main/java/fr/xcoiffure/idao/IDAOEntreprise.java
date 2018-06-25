package fr.xcoiffure.idao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Entreprise;

public interface IDAOEntreprise extends JpaRepository<Entreprise, Integer> {
	
//	@Query("select distinct e from Entreprise e left join fetch e.entrepriseAssocies ea")
//	List<Entreprise> findAllWithentrepriseAssocies();
//	
//	@Query("select distinct e from Entreprise e left join fetch e.employes em")
//	List<Entreprise> findAllWithemployes();
//	
//	@Query("select distinct e from Entreprise e left join fetch e.services s")
//	List<Entreprise> findAllWithservices();
}
