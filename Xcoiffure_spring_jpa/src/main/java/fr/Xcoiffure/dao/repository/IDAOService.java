package fr.Xcoiffure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Service;

public interface IDAOService extends JpaRepository<Service, Integer> {

}
