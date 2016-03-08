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
	ArrayList<Pokemons> joueur1;
	ArrayList<Pokemons> joueur2;

	public static void main(String[] args) {
		Introduction();

		// /* Testing */
		// TypesJDBC typesJDBC = new TypesJDBC();
		// typesJDBC.EstablishConnection();
		//
		// AttaquesJDBC attaquesJDBC = new AttaquesJDBC();
		// ArrayList<Attaques> attaques = attaquesJDBC.Select();
		// for (Attaques attaque : attaques) {
		// System.out.println(attaque.toString());
		// }
		//
		// TypeDePokemonsJDBC typeDePokemonsJDBC = new TypeDePokemonsJDBC();
		// ArrayList<TypeDePokemons> typeDePokemons =
		// typeDePokemonsJDBC.Select();
		// for (TypeDePokemons typeDePokemon : typeDePokemons) {
		// System.out.println(typeDePokemon.toString());
		// }
		//
		// Types type = typesJDBC.Select(4);
		//
		// ArrayList<Types> types = typesJDBC.Select();
		// for (Types types2 : types) {
		// System.out.println(types2.getNom());
		// System.out.println("  Fort contre :");
		// for (Types types3 : types2.getFortContre()) {
		// System.out.println("    " + types3.getNom());
		// }
		// System.out.println("  Faible contre :");
		// for (Types types3 : types2.getFaibleContre()) {
		// System.out.println("    " + types3.getNom());
		// }
		// }

		// DresseursJDBC dresseursJDBC = new DresseursJDBC();
		// ArrayList<Dresseurs> dresseurs = dresseursJDBC.Select();
		// for (Dresseurs dresseur : dresseurs) {
		// System.out.println(dresseur.toString());
		// }
		//
		// dresseurs = dresseursJDBC.SelectWithPokemons();
		// for (Dresseurs dresseur : dresseurs) {
		// System.out.println(dresseur.toString());
		// }

		// PokemonsJDBC pokeJDBC = new PokemonsJDBC();
		// pokeJDBC.Insert(dresseurs.get(5).getPokemons());
		// dresseurs.get(5).getPokemons().remove(0);
		// dresseurs.get(5).getPokemons().remove(1);
		// pokeJDBC.Delete(dresseurs.get(5).getPokemons());

		Setup();
		DresseursJDBC dresseursJDBC = new DresseursJDBC();
		ArrayList<Dresseurs> dresseurs = dresseursJDBC.SelectWithPokemons();
		for (Dresseurs dresseur : dresseurs) {
			System.out.println(dresseur.toString());
		}
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

		dresseurs = dresseurJDBC.Insert(dresseurs);

		PokemonsJDBC pokeJDBC = new PokemonsJDBC();
		for (Dresseurs dresseurTmp : dresseurs) {
			dresseurTmp.setPokemons(Pokemons.GetRandoms(6, dresseurTmp));
			pokeJDBC.Insert(dresseurTmp.getPokemons());
		}
	}
}
