package fr.Xcoiffure.dao.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Produit;

public interface IDAOProduit extends JpaRepository<Produit, Integer>
{
	@Query("select p from Produit p where p.libelle = :libelle")
	public Produit findAvecLibelle(@Param("libelle") String libelle);
	
	public List<Produit> findByPrixBetween(Double a, Double b);
	
	@Transactional
	public void deleteByLibelleStartsWithIgnoreCase(String libelle);
}