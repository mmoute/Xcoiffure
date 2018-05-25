package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="adresse")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ADR_ID")
	private int id;
	
	@Column(name="ADR_RUE", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String nomRue;
	
	@Column(name="ADR_CP", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String codePostal;
	
	@Column(name="ADR_VILLE", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String ville;
	
	@ManyToMany(mappedBy="clientAssocies")
	private List<Client> adresseClients;
	
	@ManyToMany(mappedBy="entrepriseAssocies")
	private List<Entreprise> adresseEntreprises;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	
	public List<Client> getAdresseClients() {
		return adresseClients;
	}
	public void setAdresseClients(List<Client> adresseClients) {
		this.adresseClients = adresseClients;
	}

	
	public List<Entreprise> getAdresseEntreprises() {
		return adresseEntreprises;
	}
	public void setAdresseEntreprises(List<Entreprise> adresseEntreprises) {
		this.adresseEntreprises = adresseEntreprises;
	}

	
	public Adresse() {
}

}
