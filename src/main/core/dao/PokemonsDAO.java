package core.dao;

import java.util.ArrayList;

import core.pokemon.Pokemons;

public interface PokemonsDAO {
	public ArrayList<Pokemons> Select();
	
	public Pokemons Select(Integer id_pokemon);
}
