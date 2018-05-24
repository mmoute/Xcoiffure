package model;

import java.util.ArrayList;
import java.util.Date;

public class Rdv {
	
	private int id;
	private boolean valide;
	private Date date;
	private Client client = new Client();
	private Service service = new Service();
	private Employes employes = new Employes();
	

	
	

	public Rdv() {
}




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





}
