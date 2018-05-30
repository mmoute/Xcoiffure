package fr.Xcoiffure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Entreprise;

public interface IDAOEntreprise extends JpaRepository<Entreprise, Integer> {

}
