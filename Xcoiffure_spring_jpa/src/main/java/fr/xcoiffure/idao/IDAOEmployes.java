package fr.xcoiffure.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Employes;

public interface IDAOEmployes extends JpaRepository<Employes, Integer> {

}
