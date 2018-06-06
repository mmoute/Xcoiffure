package fr.xcoiffure.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Service;

public interface IDAOService extends JpaRepository<Service, Integer> {

}
