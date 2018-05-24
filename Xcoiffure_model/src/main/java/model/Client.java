package model;

import java.util.Date;
import java.util.Scanner;

public class Client {

	
	private int id;
	private String nom;
	private String prenom;
	private Adresse adresse = new Adresse();
	private String naissance;
	
	
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
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public String getNaissance() {
		return naissance;
	}
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	
	
	public Client() {
}
	
}
