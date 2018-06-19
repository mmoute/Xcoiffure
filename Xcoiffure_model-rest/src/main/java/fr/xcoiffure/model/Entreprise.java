package fr.xcoiffure.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="entreprise")
public class Entreprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ENT_ID")
	@JsonView(Views.ViewCommons.class)
	private int id;
	
	@Column(name="ENT_NOM_SOCIETE", nullable=false)
	@NotEmpty
	@Size(max=50)
	@JsonView(Views.ViewCommons.class)
	private String nom_societe;
	
	@Column(name="ENT_NOM_GERANT", nullable=false)
	@NotEmpty
	@Size(max=50)
	@JsonView(Views.ViewCommons.class)
	private String nom_gerant;
	
	@OneToMany(mappedBy="entreprise")
	@JsonView(Views.ViewEntreprise.class)
	private List<Service> services;
	
	@OneToMany(mappedBy="entreprise")
	@JsonView(Views.ViewEntreprise.class)
	private List<Employes> employes;
	
	@ManyToMany  (cascade= {CascadeType.REMOVE , CascadeType.REFRESH })
	@JsonView(Views.ViewEntreprise.class)
	@JoinTable(
	name="adrentreprise",
	joinColumns=@JoinColumn(name="ADRENTREPRISE_ENT_ID", referencedColumnName="ENT_ID"),
	inverseJoinColumns=@JoinColumn(name="ADRENTREPRISE_ADR_ID", referencedColumnName="ADR_ID"))
	private List<Adresse> entrepriseAssocies;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_societe() {
		return nom_societe;
	}

	public void setNom_societe(String nom_societe) {
		this.nom_societe = nom_societe;
	}

	public String getNom_gerant() {
		return nom_gerant;
	}

	public void setNom_gerant(String nom_gerant) {
		this.nom_gerant = nom_gerant;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Employes> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employes> employes) {
		this.employes = employes;
	}

	public List<Adresse> getEntrepriseAssocies() {
		return entrepriseAssocies;
	}

	public void setEntrepriseAssocies(List<Adresse> entrepriseAssocies) {
		this.entrepriseAssocies = entrepriseAssocies;
	}

	public Entreprise() {
}

}
