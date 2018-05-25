package model;

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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="entreprise")
public class Entreprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ENT_ID")
	private int id;
	
	@Column(name="ENT_NOM_SOCIETE", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String nom_societe;
	
	@Column(name="ENT_NOM_GERANT", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String nom_gerant;
	
	@OneToMany(mappedBy="entreprise")
	private List<Service> services;
	
	@OneToMany(mappedBy="entreprise")
	private List<Employes> employes;
	
	@ManyToMany  (cascade= {CascadeType.REMOVE , CascadeType.REFRESH })
	@JoinTable(
	name="adrfournisseur",
	joinColumns=@JoinColumn(name="ADRFOURNISSEUR_ENT_ID", referencedColumnName="ENT_ID"),
	inverseJoinColumns=@JoinColumn(name="ADRFOURNISSEUR_ADR_ID", referencedColumnName="ADR_ID"))
	private List<Adresse> fournisseurAssocies;
	

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

	public List<Adresse> getFournisseurAdresses() {
		return fournisseurAssocies;
	}
	public void setFournisseurAdresses(List<Adresse> fournisseurAdresses) {
		this.fournisseurAssocies = fournisseurAdresses;
	}

	public Entreprise() {
}

}
