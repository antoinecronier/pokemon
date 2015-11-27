package pokemon;

import java.util.ArrayList;

public class Zones {
	private int id_zone;
	private String nom;
	private ArrayList<Positions> positions;
	private ArrayList<Dresseurs> dresseurs;
	
	public Zones(int id_zone, String nom, ArrayList<Positions> positions,
			ArrayList<Dresseurs> dresseurs) {
		this.id_zone = id_zone;
		this.nom = nom;
		this.positions = positions;
		this.dresseurs = dresseurs;
	}
	
	public Zones() {
	}

	public int getId_zone() {
		return id_zone;
	}

	public void setId_zone(int id_zone) {
		this.id_zone = id_zone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public ArrayList<Positions> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Positions> positions) {
		this.positions = positions;
	}

	public ArrayList<Dresseurs> getDresseurs() {
		return dresseurs;
	}

	public void setDresseurs(ArrayList<Dresseurs> dresseurs) {
		this.dresseurs = dresseurs;
	}
}
