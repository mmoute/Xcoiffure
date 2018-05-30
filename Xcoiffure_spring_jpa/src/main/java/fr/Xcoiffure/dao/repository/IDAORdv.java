package fr.Xcoiffure.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Client;
import model.Rdv;

public interface IDAORdv extends JpaRepository<Rdv, Integer> {
	
	public List<Rdv> findByClientNomContains(String nom);

}
