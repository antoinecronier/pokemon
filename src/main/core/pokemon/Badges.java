package main.core.pokemon;

public class Badges {
	private int id_badge;
	private String nom;
	private Zones zone;
	private Dresseurs maitre;
	
	public Badges(String nom, Zones zone, Dresseurs maitre) {
		this.nom = nom;
		this.zone = zone;
		this.maitre = maitre;
	}
	
	public Badges() {
	}

	public int getId_badge() {
		return id_badge;
	}

	public void setId_badge(int id_badge) {
		this.id_badge = id_badge;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Zones getZone() {
		return zone;
	}

	public void setZone(Zones zone) {
		this.zone = zone;
	}

	public Dresseurs getMaitre() {
		return maitre;
	}

	public void setMaitre(Dresseurs maitre) {
		this.maitre = maitre;
	}
}
