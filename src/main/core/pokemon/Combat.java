package main.core.pokemon;

import java.util.ArrayList;

import main.core.jdbc.AttaquesJDBC;
import main.core.jdbc.DresseursJDBC;
import main.core.jdbc.TypeDePokemonsJDBC;
import main.core.jdbc.TypesJDBC;

public class Combat {
	ArrayList<Pokemons> joueur1;
	ArrayList<Pokemons> joueur2;
	
	public static void main(String[] args) {
        Introduction();
        
        /* Testing */
        TypesJDBC typesJDBC = new TypesJDBC();
        typesJDBC.EstablishConnection();
        
        AttaquesJDBC attaquesJDBC = new AttaquesJDBC();
        ArrayList<Attaques> attaques = attaquesJDBC.Select();
        for (Attaques attaque : attaques) {
			System.out.println(attaque.toString());
		}
        
        TypeDePokemonsJDBC typeDePokemonsJDBC = new TypeDePokemonsJDBC();
        ArrayList<TypeDePokemons> typeDePokemons = typeDePokemonsJDBC.Select();
        for (TypeDePokemons typeDePokemon : typeDePokemons) {
        	System.out.println(typeDePokemon.toString());
		}
        
        Types type = typesJDBC.Select(4);
        
        ArrayList<Types> types = typesJDBC.Select();
        for (Types types2 : types) {
			System.out.println(types2.getNom());
			System.out.println("  Fort contre :");
			for (Types types3 : types2.getFortContre()) {
				System.out.println("    " + types3.getNom());	
			}
			System.out.println("  Faible contre :");
			for (Types types3 : types2.getFaibleContre()) {
				System.out.println("    " + types3.getNom());	
			}
		}
        
        DresseursJDBC dresseursJDBC = new DresseursJDBC();
        ArrayList<Dresseurs> dresseurs = dresseursJDBC.Select();
        for (Dresseurs dresseur : dresseurs) {
        	System.out.println(dresseur.toString());
		}
        
        dresseurs = dresseursJDBC.SelectWithPokemons();
        for (Dresseurs dresseur : dresseurs) {
        	System.out.println(dresseur.toString());
		}
    }

	private static void Introduction() {
		System.out.println("Pr�paration des pok�mons");
	}
	
	private void Setup(){
		ArrayList<Attaques> attaques1 = new ArrayList<Attaques>();
		
		ArrayList<Types> typeListFort = new ArrayList<Types>();
		typeListFort.add(new Types("Eau", null, null));
		typeListFort.add(new Types("Vol", null, null));
		
		ArrayList<Types> typeListFaible = new ArrayList<Types>();
		typeListFaible.add(new Types("Roche", null, null));
		typeListFaible.add(new Types("Sol", null, null));
		
		Types typeElec = new Types("Electrik", typeListFort, typeListFaible);
		
		ArrayList<Types> pikachu = new ArrayList<Types>();
		pikachu.add(typeElec);
		
		attaques1.add(new Attaques("�claire", 40, 90, typeElec));
		
		//joueur1.add(new Pokemons("Pikachu",20,attaques1, new TypeDePokemons("Pikachu", 30, 50, 20, 30, 60, 40), pikachu));
	}
}
