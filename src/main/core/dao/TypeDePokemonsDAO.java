package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Positions;
import main.core.pokemon.TypeDePokemons;

public interface TypeDePokemonsDAO {
	public ArrayList<TypeDePokemons> Select();
	
	public TypeDePokemons Select(Integer id_type_de_pokemon);
	
	public void Insert(ArrayList<TypeDePokemons> typeDePokemons);
	public void Delete(ArrayList<TypeDePokemons> typeDePokemons);
	public void Update(ArrayList<TypeDePokemons> typeDePokemons);
}
