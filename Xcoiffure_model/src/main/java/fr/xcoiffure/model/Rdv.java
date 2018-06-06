package fr.xcoiffure.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="rdv")
public class Rdv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RDV_ID")
	private int id;
	
	@Column(name="RDV_VALIDE", nullable = false)
	@NotEmpty
	private boolean valide;
	
	@Column(name="RDV_DATE", nullable=true)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date date;
		
	@ManyToOne
	@JoinColumn(name="RDV_CLI_ID")
	private Client client;

	@ManyToOne
	@JoinColumn(name="RDV_SER_ID")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name="RDV_EMP_ID")
	private Employes employes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Employes getEmployes() {
		return employes;
	}

	public void setEmployes(Employes employes) {
		this.employes = employes;
	}

	
	
	public Rdv() {
}



}
