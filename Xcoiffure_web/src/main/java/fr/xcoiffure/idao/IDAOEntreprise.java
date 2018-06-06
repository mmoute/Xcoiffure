package fr.xcoiffure.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Entreprise;

public interface IDAOEntreprise extends JpaRepository<Entreprise, Integer> {

}
