package fr.xcoiffure.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.modele1.Fournisseur;



public interface IDAOFournisseur extends JpaRepository <Fournisseur, Integer> {

}
