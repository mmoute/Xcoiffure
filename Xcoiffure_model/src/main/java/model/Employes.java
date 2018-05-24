package model;

public class Employes {
	
	private int id;
	private String nom;
	private String prenom;
	private boolean indisponibilite;
	
	
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
	

	public Employes() {
}
	
	

}
