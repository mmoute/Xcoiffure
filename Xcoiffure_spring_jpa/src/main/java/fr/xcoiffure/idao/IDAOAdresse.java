package fr.xcoiffure.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Adresse;

public interface IDAOAdresse extends JpaRepository<Adresse, Integer> {

}
