package fr.xcoiffure.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name="employes")
public class Employes {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	@JsonView(Views.ViewCommons.class)
	private int id;
	
	@Column(name="EMP_NOM", length=100, nullable=false)
	@NotEmpty
	@Size(max=50)
	@JsonView(Views.ViewCommons.class)
	private String nom;
	
	@Column(name="EMP_PRENOM", length=100, nullable=false)
	@NotEmpty
	@Size(max=50)
	@JsonView(Views.ViewCommons.class)
	private String prenom;
	
	@Column(name="EMP_INDISPONIBILITE", nullable = false)
	@NotEmpty
	@JsonView(Views.ViewCommons.class)
	private boolean indisponibilite;
	
	@ManyToOne
	@JoinColumn(name="EMP_ENTREPRISE_ID")
//	@JsonView(Views.ViewEmployes.class)
	private Entreprise entreprise;
	
	@OneToMany(mappedBy="employes")
	@JsonView(Views.ViewEmployes.class)
	private List<Rdv> rdvs;
	
	
	
	
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean isIndisponibilite() {
		return indisponibilite;
	}

	public void setIndisponibilite(boolean indisponibilite) {
		this.indisponibilite = indisponibilite;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public Employes() {
}
	
	

}
