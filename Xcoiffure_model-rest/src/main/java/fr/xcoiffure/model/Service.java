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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name="service")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SER_ID")
	@JsonView(Views.ViewCommons.class)
	private int id;
	
	@Column(name="SER_NOM", length=100, nullable=false)
	@NotEmpty
	@Size(max=50)
	@JsonView(Views.ViewCommons.class)
	private String nomService;
	
	@Column(name="SER_PRIX" ,columnDefinition="DECIMAL(10,2) DEFAULT 0")
	@Min(0)
	@JsonView(Views.ViewCommons.class)
	private float prix;
	
	@Column(name="SER_TEMPS", nullable=false)
	@NotEmpty
	@JsonView(Views.ViewCommons.class)
	private int temps;
	
	@ManyToOne
	@JoinColumn(name="SER_CATEGORIE_ID")
	@JsonView(Views.ViewService.class)
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="SER_ENTREPRISE_ID")
	@JsonView(Views.ViewService.class)
	private Entreprise entreprise;
	
	@OneToMany(mappedBy="service")
	@JsonView(Views.ViewService.class)
	private List<Rdv> rdvs;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nom) {
		this.nomService = nom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
	
	
	public Service() {
}
	
	
}
