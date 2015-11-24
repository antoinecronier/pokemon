package pokemon;

import java.util.ArrayList;

public class Types {
	private int id_types;
	private String nom;
	private ArrayList<Types> fortContre;
	private ArrayList<Types> faibleContre;
	
	public Types(String nom, ArrayList<Types> fortContre,
			ArrayList<Types> faibleContre) {
		super();
		this.nom = nom;
		this.fortContre = fortContre;
		this.faibleContre = faibleContre;
	}
	
	public Types() {
		// TODO Auto-generated constructor stub
	}

	public int getId_types() {
		return id_types;
	}
	public void setId_types(int id_types) {
		this.id_types = id_types;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Types> getFortContre() {
		return fortContre;
	}
	public void setFortContre(ArrayList<Types> fortContre) {
		this.fortContre = fortContre;
	}
	public ArrayList<Types> getFaibleContre() {
		return faibleContre;
	}
	public void setFaibleContre(ArrayList<Types> faibleContre) {
		this.faibleContre = faibleContre;
	}
}
