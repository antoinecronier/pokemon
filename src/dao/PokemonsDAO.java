package dao;

import java.util.ArrayList;

import pokemon.Pokemons;

public interface PokemonsDAO {
	public ArrayList<Pokemons> Select();
	
	public Pokemons Select(Integer id_pokemon);
}
