package fr.xcoiffure.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table (name="categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CAT_ID")
	@JsonView(Views.ViewCommons.class)
	private int id;
	
	@Column(name="CAT_NOM", length=100, nullable=false)
	@NotEmpty
	@Size(max=50)
	@JsonView(Views.ViewCommons.class)
	private String nom;
	
	@OneToMany(mappedBy="categorie")
	@JsonView(Views.ViewCategorie.class)
	private List<Service> services;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
	public Categorie() {
}
	
	
}
