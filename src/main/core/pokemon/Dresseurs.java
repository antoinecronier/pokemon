package main.core.pokemon;

import java.util.ArrayList;

public class Dresseurs {
	private int id_dresseur;
	private String nom;
	private ArrayList<Badges> badges;
	private ArrayList<Pokemons> pokemons;
	private Positions position;
	
	public Dresseurs(String nom, ArrayList<Badges> badges,
			ArrayList<Pokemons> pokemons, Positions position) {
		this.nom = nom;
		this.badges = badges;
		this.pokemons = pokemons;
		this.position = position;
	}
	
	public Dresseurs() {
		this.badges = new ArrayList<Badges>();
		this.pokemons = new ArrayList<Pokemons>();
	}

	public int getId_dresseur() {
		return id_dresseur;
	}

	public void setId_dresseur(int id_dresseur) {
		this.id_dresseur = id_dresseur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Badges> getBadges() {
		return badges;
	}

	public void setBadges(ArrayList<Badges> badges) {
		this.badges = badges;
	}

	public ArrayList<Pokemons> getPokemons() {
		return pokemons;
	}

	public void setPokemons(ArrayList<Pokemons> pokemons) {
		this.pokemons = pokemons;
	}

	public Positions getPosition() {
		return position;
	}

	public void setPosition(Positions position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		String pokemons = new String();
		for (Pokemons pokemon : this.pokemons) {
			pokemons += "\n    " + pokemon.toString();
		}
		return "Dresseur : "+this.nom +" pokemons :\n "+ pokemons;
	}
}
