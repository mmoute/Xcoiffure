package fr.xcoiffure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {

}
