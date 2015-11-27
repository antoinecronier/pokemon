package pokemon;

import java.util.ArrayList;
import java.util.Date;

public class Pokemons {
	private int id_pokemons;
	private String surnom;
	private int niveau;
	private Date capture;
	private ArrayList<Attaques> attaques;
	private TypeDePokemons typeDePokemon;

	public Pokemons(String surnom, int niveau,
			ArrayList<Attaques> attaques, TypeDePokemons typeDePokemon) {
		this.surnom = surnom;
		this.niveau = niveau;
		this.attaques = attaques;
		this.typeDePokemon = typeDePokemon;
	}
	
	public Pokemons() {
	}
	
	public int getId_pokemons() {
		return id_pokemons;
	}
	public void setId_pokemons(int id_pokemons) {
		this.id_pokemons = id_pokemons;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Date getCapture() {
		return capture;
	}

	public void setCapture(Date capture) {
		this.capture = capture;
	}

	public ArrayList<Attaques> getAttaques() {
		return attaques;
	}
	public void setAttaques(ArrayList<Attaques> attaques) {
		this.attaques = attaques;
	}
	public TypeDePokemons getTypeDePokemon() {
		return typeDePokemon;
	}
	public void setTypeDePokemon(TypeDePokemons typeDePokemon) {
		this.typeDePokemon = typeDePokemon;
	}
}
