package main.core.pokemon;

import java.util.ArrayList;
import java.util.Date;

public class Pokemons {
	private int id_pokemons;
	private String surnom;
	private int niveau;
	private Date capture;
	private int id_dresseurs;
	private int id_type_de_pokemon;
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
	
	public int getId_type_de_pokemon() {
		return id_type_de_pokemon;
	}

	public void setId_type_de_pokemon(int id_type_de_pokemon) {
		this.id_type_de_pokemon = id_type_de_pokemon;
	}

	public int getId_dresseurs() {
		return id_dresseurs;
	}

	public void setId_dresseurs(int id_dresseurs) {
		this.id_dresseurs = id_dresseurs;
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
	
	@Override
	public String toString() {
		String result;
		result = this.getSurnom() + " niveau : " + this.getNiveau() + " \n    Type : " + this.getTypeDePokemon().toString() +"\n";
		for (Attaques attaque : this.getAttaques()) {
			result += "\n        " + attaque.toString() +"\n";
		}
		return result;
	}
}
