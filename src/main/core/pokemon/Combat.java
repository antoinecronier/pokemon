package main.core.pokemon;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import main.core.jdbc.AttaquesJDBC;
import main.core.jdbc.DresseursJDBC;
import main.core.jdbc.PokemonsJDBC;
import main.core.jdbc.TypeDePokemonsJDBC;
import main.core.jdbc.TypesJDBC;

public class Combat {
	static Dresseurs joueur1;
	static Dresseurs joueur2;

	public static void main(String[] args) {
		Introduction();
		Setup();
		Battle(joueur1, joueur2);
	}

	private static void Introduction() {
		System.out.println("Préparation des pokémons");
	}

	private static void Setup() {
		DresseursJDBC dresseurJDBC = new DresseursJDBC();
		ArrayList<Dresseurs> dresseurs = new ArrayList<Dresseurs>();

		Dresseurs dresseur1 = new Dresseurs();
		dresseur1.setNom("john");
		dresseurs.add(dresseur1);
		Dresseurs dresseur2 = new Dresseurs();
		dresseur2.setNom("alfonse");
		dresseurs.add(dresseur2);

		//dresseurs = dresseurJDBC.Insert(dresseurs);

		PokemonsJDBC pokeJDBC = new PokemonsJDBC();
		for (Dresseurs dresseurTmp : dresseurs) {
			dresseurTmp.setPokemons(Pokemons.GetRandoms(6, dresseurTmp));
			//pokeJDBC.Insert(dresseurTmp.getPokemons());
		}
		
		joueur1 = dresseurs.get(0);
		joueur2 = dresseurs.get(1);
	}
	
	private static void Battle(Dresseurs d1,Dresseurs d2){
		d2.getPokemons().get(0).setReal_pv(d2.getPokemons().get(0).getReal_pv() - d1.getPokemons().get(0).getAttaques().get(0).getPuissance());
		if (d2.getPokemons().get(0).getReal_pv() > 0) {
			d1.getPokemons().get(0).setReal_pv(d1.getPokemons().get(0).getReal_pv() - d2.getPokemons().get(0).getAttaques().get(0).getPuissance());
			if (d1.getPokemons().get(0).getReal_pv() > 0) {
				
			}
		}
	}
}
