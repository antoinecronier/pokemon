package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Dresseurs;
import main.core.pokemon.Pokemons;

public interface PokemonsDAO {
	public ArrayList<Pokemons> Select();
	
	public Pokemons Select(Integer id_pokemon);
	
	public void Insert(ArrayList<Pokemons> pokemons);
	public void Delete(ArrayList<Pokemons> pokemons);
	public void Update(ArrayList<Pokemons> pokemons);
}
