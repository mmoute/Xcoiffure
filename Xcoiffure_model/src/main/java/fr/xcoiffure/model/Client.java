package fr.xcoiffure.model;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLI_ID")
	private int id;
	
	@Column(name="CLI_NOM", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String nom;
	
	@Column(name="CLI_PRENOM", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String prenom;
	
	@Column(name="CLI_DATE_NAISSANCE", nullable=true)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date naissance;
	
	@OneToMany(mappedBy="client")
	private List<Rdv> rdvs;
	
	@ManyToMany  (cascade= {CascadeType.REMOVE , CascadeType.REFRESH })
	@JoinTable(
	name="adrclient",
	joinColumns=@JoinColumn(name="ADRCLIENT_CLI_ID", referencedColumnName="CLI_ID"),
	inverseJoinColumns=@JoinColumn(name="ADRCLIENT_ADR_ID", referencedColumnName="ADR_ID"))
	private List<Adresse> clientAssocies;
	
	
	public String toString() {
	return this.prenom + " " + this.nom;
	}

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

	public Date getNaissance() {
		return naissance;
	}
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public List<Rdv> getRdvs() {
		return rdvs;
	}
	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public List<Adresse> getClientAssocies() {
		return clientAssocies;
	}
	public void setClientAssocies(List<Adresse> clientAssocies) {
		this.clientAssocies = clientAssocies;
	}

	public Client() {
}
	
}
