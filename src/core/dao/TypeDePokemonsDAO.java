package core.dao;

import java.util.ArrayList;

import core.pokemon.TypeDePokemons;

public interface TypeDePokemonsDAO {
	public ArrayList<TypeDePokemons> Select();
	
	public TypeDePokemons Select(Integer id_type_de_pokemon);
}
