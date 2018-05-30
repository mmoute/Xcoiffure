package model;

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

@Entity
@Table (name="service")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SER_ID")
	private int id;
	
	@Column(name="SER_NOM", length=100, nullable=false)
	@NotEmpty
	@Size(max=50)
	private String nom;
	
	@Column(name="SER_PRIX" ,columnDefinition="DECIMAL(10,2) DEFAULT 0")
	@Min(0)
	private float prix;
	
	@Column(name="SER_TEMPS", nullable=false)
	@NotEmpty
	private int temps;
	
	@ManyToOne
	@JoinColumn(name="SER_CATEGORIE_ID")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="SER_ENTREPRISE_ID")
	private Entreprise entreprise;
	
	@OneToMany(mappedBy="service")
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
