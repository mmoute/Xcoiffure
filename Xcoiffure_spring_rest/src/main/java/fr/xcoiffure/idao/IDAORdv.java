package fr.xcoiffure.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.xcoiffure.model.Rdv;

public interface IDAORdv extends JpaRepository<Rdv, Integer> {
	
	public List<Rdv> findByClientNomContains(String nom);
}
