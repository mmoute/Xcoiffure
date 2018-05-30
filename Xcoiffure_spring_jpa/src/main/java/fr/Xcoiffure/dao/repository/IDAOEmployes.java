package fr.Xcoiffure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Employes;

public interface IDAOEmployes extends JpaRepository<Employes, Integer> {

}
