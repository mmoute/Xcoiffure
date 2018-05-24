package model;

public class Entreprise {
	
	private int id;
	private String nom;
	private String nom_gerant;
	
	
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
	
	public String getNom_gerant() {
		return nom_gerant;
	}
	public void setNom_gerant(String nom_gerant) {
		this.nom_gerant = nom_gerant;
	}
	
	
	public Entreprise() {
}

}
