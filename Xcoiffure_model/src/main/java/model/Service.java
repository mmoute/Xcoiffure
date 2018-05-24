package model;

import java.util.ArrayList;



public class Service {
	
	private int id;
	private String nom;
	private float prix;
	private int temps;
	
	private ArrayList<Categorie> categorie = new ArrayList<Categorie>();
	private ArrayList<Entreprise> entreprises = new ArrayList<Entreprise>();
	

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
	
	public ArrayList<Categorie> getCategorie() {
		return categorie;
	}
	public void setCategorie(ArrayList<Categorie> categorie) {
		this.categorie = categorie;
	}
	
	public ArrayList<Entreprise> getEntreprises() {
		return entreprises;
	}
	public void setEntreprises(ArrayList<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	
		
	public Service() {
}
	
	
}
